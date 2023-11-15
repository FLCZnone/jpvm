package org.jpvm.excptions;

import org.jpvm.excptions.pyobjs.PyExceptionObject;
import org.jpvm.excptions.types.PyBaseExceptionType;
import org.jpvm.excptions.types.PyExceptionType;
import org.jpvm.objects.PyObject;
import org.jpvm.python.BuiltIn;

public class ExceptionInfo {

  /** {@link PyBaseExceptionType} */
  private PyBaseExceptionType excType;
  /** {@link PyExceptionObject} */
  private PyExceptionObject excValue;
  /** {@link PyTraceBackObject} */
  private PyTraceBackObject excTrace;

  private ExceptionInfo previous;

  public ExceptionInfo(
      PyBaseExceptionType excType,
      PyExceptionObject excValue,
      ExceptionInfo previous,
      PyTraceBackObject excTrace) {
    this.excType = excType;
    this.excValue = excValue;
    this.previous = previous;
    this.excTrace = excTrace;
  }

  public ExceptionInfo() {}

  public PyBaseExceptionType getExcType() {
    return excType;
  }

  public void setExcType(PyObject excType) {
    if (excType != null && excType != BuiltIn.None) this.excType = (PyExceptionType) excType;
  }

  public ExceptionInfo getPrevious() {
    return previous;
  }

  public void setPrevious(ExceptionInfo previous) {
    this.previous = previous;
  }

  public PyTraceBackObject getExcTrace() {
    return excTrace;
  }

  public void setExcTrace(PyTraceBackObject excTrace) {
    this.excTrace = excTrace;
  }

  public PyExceptionObject getExcValue() {

    return excValue;
  }

  public void setExcValue(PyExceptionObject excValue) {
    this.excValue = excValue;
  }
}
