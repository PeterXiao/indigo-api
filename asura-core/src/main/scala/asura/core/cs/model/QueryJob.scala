package asura.core.cs.model

case class QueryJob(
                     group: String,
                     project: String,
                     text: String,
                     triggerType: String,
                   ) extends QueryPage
