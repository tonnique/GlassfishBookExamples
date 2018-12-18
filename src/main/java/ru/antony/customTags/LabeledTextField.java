package ru.antony.customTags;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class LabeledTextField extends SimpleTagSupport {

    private String label;
    private String value = "";
    private String name;

    @Override
    public void doTag() throws JspException, IOException {
        JspContext jspContext = getJspContext();
        JspWriter jspWriter = jspContext.getOut();
        jspWriter.print("<tr>");
        jspWriter.print("<td>");
        jspWriter.print("<label for=\"" + name + "\">");
        jspWriter.print("<strong>");
        jspWriter.print(label + ": ");
        jspWriter.print("</strong>");
        jspWriter.print("</label>");
        jspWriter.print("</td>");
        jspWriter.print("<td>");
        jspWriter.print("<input id=\"" + name + "\" type=\"text\" name=\"");
        jspWriter.print(name);
        jspWriter.print("\" ");
        jspWriter.print("value=\"");
        jspWriter.print(value);
        jspWriter.print("\" ");
        jspWriter.print("size=\"25\" />");
        jspWriter.print("</td>");
        jspWriter.print("</tr>");
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}