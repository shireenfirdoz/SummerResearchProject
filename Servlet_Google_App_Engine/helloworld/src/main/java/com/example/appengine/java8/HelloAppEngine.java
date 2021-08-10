/*
 * Copyright 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.appengine.java8;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

// With @WebServlet annotation the webapp/WEB-INF/web.xml is no longer required.
@WebServlet(name = "HelloAppEngine", value = "/hello")
public class HelloAppEngine extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    handleRequest(request, response);
  }

  
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    handleRequest(request, response);
  }
  
  private static void handleRequest(HttpServletRequest req, HttpServletResponse res) throws IOException {
    
    PrintWriter out = res.getWriter();
    res.setContentType("text/plain");

    String paramName = "name";
    String paramValue = req.getParameter(paramName);
    
    PersonData pd = new PersonData();
    pd.setFirstName(paramValue);
    
  Gson gson = new Gson();
   
    //  Java object to JSON string
    String jsonInString = gson.toJson(pd);

    out.write("data : ");
    out.write(" = ");
    out.write(jsonInString);
    out.write("n");


    out.close();

}
 

}
