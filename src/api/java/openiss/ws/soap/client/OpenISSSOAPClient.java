package api.java.openiss.ws.soap.client;

import api.java.openiss.ws.soap.service.OpenISSSOAPService;

import java.io.IOException;
import java.net.URL;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

@WebServlet(name = "OpenISSSOAPClient", urlPatterns = {"/OpenISSSOAPClient"})
public class OpenISSSOAPClient extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String uri = request.getParameter("url");
        String type = request.getParameter("requestType");
        String fileIn = request.getParameter("fileIn");

//        URL url = new URL("http://localhost:7779/ws/xmlread?wsdl");
        URL url = new URL(null, "http://localhost:7779/ws/xmlread?wsdl", new sun.net.www.protocol.http.Handler());

        QName qname = new QName("http://service.web.soen487/", "XMLReaderImplService");
        Service service = Service.create(url, qname);
        OpenISSSOAPService xmlRead = service.getPort(OpenISSSOAPService.class);
        if(!fileIn.isEmpty() && !fileIn.equals("")){
            xmlRead.doCanny(fileIn);
        }
        String result = xmlRead.fetchXML(uri, type);
        request.setAttribute("result", result);
        request.getRequestDispatcher("/WEB-INF/views/XMLOutput.jsp").forward(request, response);
    }

}