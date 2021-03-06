package asura.core.cs.assertion

import asura.core.cs.assertion.engine.{AssertResult, FailAssertResult, PassAssertResult}

import scala.concurrent.Future

object IsNull extends Assertion {

  override val name: String = Assertions.IS_NULL

  override def assert(actual: Any, expect: Any): Future[AssertResult] = {
    Future.successful(apply(actual, expect))
  }

  def apply(actual: Any, expect: Any): AssertResult = {
    if (null != expect && expect.isInstanceOf[Boolean]) {
      if (expect.asInstanceOf[Boolean]) {
        if (null == actual) PassAssertResult() else FailAssertResult()
      } else {
        if (null == actual) FailAssertResult() else PassAssertResult()
      }
    } else {
      FailAssertResult(msg = AssertResult.MSG_INCOMPARABLE)
    }
  }
}
