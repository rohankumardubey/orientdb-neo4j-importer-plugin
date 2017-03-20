package com.orientechnologies.orient.http;

import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.server.network.protocol.http.OHttpRequest;
import com.orientechnologies.orient.server.network.protocol.http.OHttpResponse;
import com.orientechnologies.orient.server.network.protocol.http.OHttpUtils;
import com.orientechnologies.orient.server.network.protocol.http.command.OServerCommandAuthenticatedServerAbstract;

import java.io.IOException;

/**
 * Created by gabriele on 27/02/17.
 */
public class OServerCommandNeo4jImporter extends OServerCommandAuthenticatedServerAbstract {

  ONeo4jImporterHandler handler;
  private static final String[] NAMES = { "GET|neo4j-importer/*", "POST|neo4j-importer/*" };

  public OServerCommandNeo4jImporter() {
    super("server.profiler");
    this.handler = new ONeo4jImporterHandler(super.getServer());
  }

  @Override
  public boolean execute(OHttpRequest iRequest, OHttpResponse iResponse) throws Exception {
    final String[] parts = checkSyntax(iRequest.getUrl(), 2, "Syntax error: auditing/<db>/<action>");

    if ("POST".equalsIgnoreCase(iRequest.httpMethod)) {
      doPost(iRequest, iResponse, parts);
    }
    if ("GET".equalsIgnoreCase(iRequest.httpMethod)) {
      doGet(iRequest, iResponse, parts);
    }
    return false;
  }

  private void doGet(OHttpRequest iRequest, OHttpResponse iResponse, String[] parts) throws IOException {

    if ("status".equalsIgnoreCase(parts[1])) {
      ODocument status = handler.status();
      iResponse.send(OHttpUtils.STATUS_OK_CODE, "OK", OHttpUtils.CONTENT_JSON, status.toJSON("prettyPrint"), null);
    }
    else {
      throw new IllegalArgumentException("");
    }
  }

  private void doPost(OHttpRequest iRequest, OHttpResponse iResponse, String[] parts) throws IOException {

    if ("job".equalsIgnoreCase(parts[1])) {
      ODocument cfg = new ODocument().fromJSON(iRequest.content);
      handler.executeImport(cfg);
      iResponse.send(OHttpUtils.STATUS_OK_CODE, "OK", OHttpUtils.CONTENT_JSON, null, null);

    } else if ("test".equalsIgnoreCase(parts[1])) {
      ODocument cfg = new ODocument().fromJSON(iRequest.content);
      try {
        handler.checkConnection(cfg);
      } catch (Exception e) {
        throw new IllegalArgumentException(e);
      }
      iResponse.send(OHttpUtils.STATUS_OK_CODE, "OK", OHttpUtils.CONTENT_JSON, null, null);
    }
  }

  @Override
  public String[] getNames() {
    return NAMES;
  }
}
