package main.util;

public class healthcode_picture {
/*<%@ page import="java.io.ByteArrayOutputStream" %>
<%@ page import="java.util.Base64" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import=" java.text.*, java.util.*" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%! int flag = 2;
    private static final String CHARSET = "utf-8";
    private static final String FORMAT = "png";
%>
 <%String name = request.getParameter("name");
     String id = request.getParameter("id");
     String code = request.getParameter("code");
     String phone = request.getParameter("phone");
     String visitedRiskArea = request.getParameter("visitedRiskArea");
     String visitedAbroad = request.getParameter("visitedAbroad");
     String contactWithPatient = request.getParameter("contactWithPatient");
     String confirmedOrSuspected = request.getParameter("confirmedOrSuspected");
     String[] healthStatus = request.getParameterValues("healthStatus");
     name = new String(name.getBytes("ISO-8859-1"),"utf-8");
 %>
<%    if(visitedRiskArea.equals("yes")|| visitedAbroad.equals("yes")) flag = 0; %>
<%    if((healthStatus.length == 1) && !(healthStatus[0]).equals("normal")) flag = 0;%>
<%   if(confirmedOrSuspected.equals("yes")|| contactWithPatient.equals("yes")) flag = 1;%>
<%    if((healthStatus.length >= 2)) flag = 1;%>
<%  Date nowTime = new Date();
    SimpleDateFormat matter = new SimpleDateFormat(
        "现在时间:yyyy年MM月dd日E HH时mm分ss秒");%>

<p> <%=name%></p>
<p> <%=matter.format(nowTime)%></p>
<%
    String text = "健康码";
    int width = 400;
    int height = 400;
    Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
    hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
    hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
    int BLACK = 0xFF000000;
    int YELLOW = 0xFFFFFF00;
    int RED = 0xFFFF0000;
    int GREEN = 0xFF008000;
    int color = YELLOW;

    switch (flag) {
        case 0:
            color = YELLOW;
            break;
        case 1:
            color = RED;
            break;
        case 2:
            color = GREEN;
            break;
        default:
            color = YELLOW;
            break;
    }

    QRCodeWriter qrCodeWriter = new QRCodeWriter();
    BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height, hints);

    java.awt.image.BufferedImage image = new java.awt.image.BufferedImage(width, height, java.awt.image.BufferedImage.TYPE_INT_RGB);
    for (int x = 0; x < width; x++) {
        for (int y = 0; y < height; y++) {
            int pixelColor = bitMatrix.get(x, y) ? BLACK : 0xFFFFFFFF;
            if (pixelColor == BLACK) {
                image.setRGB(x, y, color);
            } else {
                image.setRGB(x, y, 0xFFFFFFFF);
            }
        }
    }

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    javax.imageio.ImageIO.write(image, "png", baos);
    baos.flush();
    byte[] imageBytes = baos.toByteArray();
    baos.close();
    String base64Image = Base64.getEncoder().encodeToString(imageBytes);
%>

<img src="data:image/png;base64,<%= base64Image %>" alt="QR code">
</body>
</html>
*/
}
