package org.jpvm.objects.types;

import org.jpvm.objects.PyListObject;

import java.util.ArrayList;

public class PyBaseObjectType extends PyTypeType {

  public PyBaseObjectType() {
    mro = new ArrayList<>();
    name = "object";
  }
}
