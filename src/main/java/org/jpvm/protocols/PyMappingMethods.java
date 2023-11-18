package org.jpvm.protocols;

import org.jpvm.exceptions.PyErrorUtils;
import org.jpvm.exceptions.jobjs.PyException;
import org.jpvm.objects.PyObject;

public interface PyMappingMethods {

  /** implementation of corresponding cpython mp_length */
  default PyObject mpLength() throws PyException {
    return PyErrorUtils.pyErrorFormat(
        PyErrorUtils.NotImplementedError, "mpLength is not implemented");
  }

  /** implementation of corresponding cpython mp_subscript */
  default PyObject mpSubscript(PyObject o) throws PyException {
    return PyErrorUtils.pyErrorFormat(
        PyErrorUtils.NotImplementedError, "mpSubscript is not implemented");
  }

  /** implementation of corresponding cpython mp_ass_subscript */
  default PyObject mpAssSubscript(PyObject key, PyObject val) throws PyException {
    return PyErrorUtils.pyErrorFormat(
        PyErrorUtils.NotImplementedError, "mpAssSubscript is not implemented");
  }
}
