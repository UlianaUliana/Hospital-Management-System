package org.example.hospital_management_system.views;

import io.dropwizard.views.View;

public class IndexView extends View {
  private String name;
  public IndexView(String name) {
    super("index.ftl");
    this.name = name;
  }
  public String getName() {
    return name;
  }
}
