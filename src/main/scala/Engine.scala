package org.template.tensorflow

import org.apache.predictionio.controller.IEngineFactory
import org.apache.predictionio.controller.Engine

/** Define Query class which serves as a wrapper for
  * new text data.
  */
case class Query(
  image: Option[String],
  data: Option[String]
) extends Serializable

/** Define PredictedResult class which serves as a
  * wrapper for a predicted class label and the associated
  * prediction confidence.
  */
case class PredictedResult(
  category: String,
  confidence: Double
) extends Serializable

/** Define ActualResult class which serves as a wrapper
  * for an observation's true class label.
  */
case class ActualResult(category: String) extends Serializable


/** Define Engine */
object TensorflowEngine extends IEngineFactory {
  def apply() = {
    new Engine(
      classOf[DataSource],
      classOf[Preparator],
      Map(
        "tf" -> classOf[TFAlgorithm]
      ),
      classOf[Serving])
  }
}