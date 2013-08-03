<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8" language="java" %>

<tag:pageWrapper sectionName="Main">
    <p>Send greeting</p>

    <c:if test="${sent}">
        <p style="color: green">Message Sent!</p>
    </c:if>

    <f:form modelAttribute="greeting" method="POST" action="send.do">
        <table>
            <tr>
                <td>Message</td>
                <td><f:input path="message"/></td>
            </tr>
            <tr>
                <td>Count</td>
                <td><f:input path="count"/></td>
            </tr>
            <!-- Submit button -->
            <tr>
               <td colspan="2" align="right">
                   <input type="submit" value="Send"/>
               </td>
           </tr>
       </table>
   </f:form>
</tag:pageWrapper>