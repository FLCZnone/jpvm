package org.jpvm.objects;

import java.util.Arrays;
import org.jpvm.excptions.PyErrorUtils;
import org.jpvm.excptions.jobjs.PyException;
import org.jpvm.excptions.jobjs.PyNotImplemented;
import org.jpvm.objects.types.PyBytesType;
import org.jpvm.protocols.PyMappingMethods;
import org.jpvm.protocols.PyNumberMethods;
import org.jpvm.protocols.PySequenceMethods;
import org.jpvm.python.BuiltIn;

public class PyBytesObject extends PyObject
    implements PyNumberMethods, PySequenceMethods, PyMappingMethods {

  public static final PyObject type = new PyBytesType();
  private byte[] data;
  private final int size;
  private PyLongObject hashCode;
  private boolean hashDone;

  public PyBytesObject(byte[] data) {
    this.data = data;
    size = data.length;
  }

  public PyBytesObject(byte[] data, int size) {
    this.data = data;
    this.size = size;
  }

  public byte[] getData() {
    return data;
  }

  public synchronized void setData(byte[] data) {
    this.data = data;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("b'");
    for (byte datum : data) {
      builder.append(Integer.toHexString((datum & 0xf0) >> 4));
      builder.append(Integer.toHexString(datum & 0xf));
    }
    builder.append("'");
    return builder.toString();
  }

  @Override
  public Object toJavaType() {
    return data;
  }

  @Override
  public PyObject getType() {
    return type;
  }

  @Override
  public PyUnicodeObject getTypeName() {
    return type.getTypeName();
  }

  @Override
  public PyUnicodeObject str() {
    return new PyUnicodeObject(toString());
  }

  @Override
  public PyUnicodeObject repr() {
    return new PyUnicodeObject(toString());
  }

  @Override
  public PyLongObject hash() {
    if (!hashDone) {
      int h = 0;
      for (byte v : data) {
        h = 31 * h + (v & 0xff);
      }
      hashDone = true;
      hashCode = new PyLongObject(h);
      return hashCode;
    }
    return hashCode;
  }

  @Override
  public PyBoolObject richCompare(PyObject o, Operator op) throws PyException {
    if (op != Operator.Py_EQ) {
      PyErrorUtils.pyErrorFormat(PyErrorUtils.TypeError, "not support operator " + op);
      return null;
    }
    if (null == o) return BuiltIn.False;
    if (o instanceof PyBytesObject bytes) {
      if (Arrays.equals(data, bytes.data)) return BuiltIn.True;
    }
    return BuiltIn.False;
  }

  @Override
  public boolean equals(Object o) {
    if (null == o) return false;
    if (o instanceof PyBytesObject bytes) {
      return Arrays.equals(data, bytes.data);
    }
    return false;
  }

  @Override
  public PyBoolObject isHashable() {
    return BuiltIn.True;
  }

  @Override
  public PyObject mpLength(PyObject o) throws PyNotImplemented {
    return new PyLongObject(data.length);
  }

  @Override
  public PyObject mpSubscript(PyObject o) throws PyException {
    return PyMappingMethods.super.mpSubscript(o);
  }

  @Override
  public PyObject mod(PyObject o) throws PyException {
    return PyNumberMethods.super.mod(o);
  }

  @Override
  public PyObject sqLength(PyObject o) throws PyNotImplemented {
    return new PyLongObject(data.length);
  }

  @Override
  public synchronized PyObject sqConcat(PyObject o) throws PyException {
    return PySequenceMethods.super.sqConcat(o);
  }

  @Override
  public synchronized PyObject sqRepeat(PyObject o) throws PyException {
    return PySequenceMethods.super.sqRepeat(o);
  }

  @Override
  public PyObject sqItem(PyObject o) throws PyException {
    return PySequenceMethods.super.sqItem(o);
  }

  @Override
  public PyObject sqContain(PyObject o) throws PyException {
    return PySequenceMethods.super.sqContain(o);
  }

  @Override
  public PyObject bool() throws PyException {
    if (size == 0) return BuiltIn.False;
    return BuiltIn.True;
  }
}
