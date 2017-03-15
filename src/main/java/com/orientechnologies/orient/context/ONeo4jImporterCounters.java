package com.orientechnologies.orient.context;

/**
 * Created by frank on 08/11/2016.
 */
public class ONeo4jImporterCounters {

  public volatile double neo4jNodeCounter                           = 0;
  public volatile double neo4jNodeNoLabelCounter                    = 0;
  public volatile double neo4jNodeMultipleLabelsCounter             = 0;
  public volatile double orientDBImportedVerticesCounter            = 0;
  public volatile double neo4jRelCounter                            = 0;
  public volatile double orientDBImportedEdgesCounter               = 0;
  public volatile double neo4jConstraintsCounter                    = 0;
  public volatile double neo4jUniqueConstraintsCounter              = 0;
  public volatile double orientDBImportedConstraintsCounter         = 0;
  public volatile double orientDBImportedUniqueConstraintsCounter   = 0;
  public volatile double orientDBImportedNotUniqueWorkaroundCounter = 0;
  public volatile double neo4jIndicesCounter                        = 0;
  public volatile double neo4jNonConstraintsIndicesCounter          = 0;
  public volatile double neo4jInternalVertexIndicesCounter          = 0;
  public volatile double neo4jInternalEdgeIndicesCounter            = 0;
  public volatile double orientDBImportedIndicesCounter             = 0;
  public volatile double neo4jTotalNodes                            = 0;
  public volatile double neo4jTotalRels                             = 0;
  public volatile double neo4jTotalUniqueConstraints                = 0;
  public volatile double neo4jTotalConstraints                      = 0;
  public volatile double neo4jTotalNodePropertyExistenceConstraints = 0;
  public volatile double neo4jTotalRelPropertyExistenceConstraints  = 0;
  public volatile double neo4jTotalIndices                          = 0;

  public volatile double importingNodesStartTime        = 0;
  public volatile double importingNodesStopTime         = 0;
  public volatile double internalVertexIndicesStartTime = 0;
  public volatile double orientDBVerticesClassCount     = 0;
  public volatile double internalVertexIndicesStopTime  = 0;
  public volatile double internalEdgeIndicesStartTime   = 0;
  public volatile double orientDBEdgeClassesCount       = 0;
  public volatile double internalEdgeIndicesStopTime    = 0;

  public ONeo4jImporterCounters() {}
}
