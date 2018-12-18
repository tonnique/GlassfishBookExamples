<%@ tag language="java" %>
<%@ attribute name="addressType" required="true" %>
<jsp:useBean id="address" scope="request" class="ru.antony.entiny.AddressBean"/>
<table cellpadding="0" cellspacing="0" border="0">
    <tr>
        <td align="right" width="70"><label for="${addressType}_line1"><strong><% out.print(new String(("Улица 1").getBytes("iso-8859-1"), "utf-8")); %> </strong></label></td>
        <td><input id="${addressType}_line1" type="text" name="${addressType}_line1" size="30"
                   maxlength="100" value="${address.line1}"></td>
    </tr>
    <tr>
        <td align="right"><label for="${addressType}_line2"><strong><% out.print(new String(("Улица 2").getBytes("iso-8859-1"), "utf-8")); %> </strong></label></td>
        <td><input id="${addressType}_line2" type="text" name="${addressType}_line2" size="30"
                   maxlength="100" value="${address.line2}"></td>
    </tr>
    <tr>
        <td align="right"><label for="${addressType}_city"><strong><% out.print(new String(("Город").getBytes("iso-8859-1"), "utf-8")); %> </strong></label></td>
        <td><input id="${addressType}_city" type="text" name="${addressType}_city" size="30"
                   value="${address.city}"></td>
    </tr>
    <tr>
        <td align="right"><label for="${addressType}_state"><strong><% out.print(new String(("Штат").getBytes("iso-8859-1"), "utf-8")); %></strong></label></td>
        <td>
            <select id="${addressType}_state" name="${addressType}_state">
                <option value=" "></option>
                <option value="AL"
                        <% if(address.getState().equals("AL"))
                            out.print(" selected "); %>>Alabama
                </option>
                <option value="AK"
                        <% if(address.getState().equals("AK"))
                            out.print(" selected "); %>>Alaska
                </option>
                <option value="AZ"
                        <% if(address.getState().equals("AZ"))
                            out.print(" selected "); %>>Arizona
                </option>
                <option value="AR"
                        <% if(address.getState().equals("AR"))
                            out.print(" selected "); %>>Arkansas
                </option>
                <option value="CA"
                        <% if(address.getState().equals("CA"))
                            out.print(" selected "); %>>California
                </option>
                <option value="CO"
                        <% if(address.getState().equals("CO"))
                            out.print(" selected "); %>>Colorado
                </option>
                <option value="CT"
                        <% if(address.getState().equals("CT"))
                            out.print(" selected "); %>>Connecticut
                </option>
                <option value="DC"
                        <% if(address.getState().equals("DC"))
                            out.print(" selected "); %>>District of Columbia
                </option>
                <option value="FL"
                        <% if(address.getState().equals("FL"))
                            out.print(" selected "); %>>Florida
                </option>
            </select>
        </td>
    </tr>
    <tr>
        <td align="right"><label for="${ addressType }_zip"><strong><% out.print(new String(("Индекс").getBytes("iso-8859-1"), "utf-8")); %> </strong></label></td>
        <td><input id="${ addressType }_zip" type="text" name="${ addressType }_zip" size="5"
                   value="${address.zip}">
        </td>
    </tr>
</table>
