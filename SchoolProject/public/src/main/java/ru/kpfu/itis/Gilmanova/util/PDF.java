package ru.kpfu.itis.Gilmanova.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Adel on 02.05.2016.
 */
public class PDF {

    public static void main(String[] args) throws IOException, DocumentException {
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
        //String getPath = request.getServletContext().getRealPath("/resources/images/usersPhoto/id_" + userId + "/");
        PdfWriter writer = PdfWriter.getInstance(document,
                new FileOutputStream("C:\\Users\\1\\Documents\\ITextTest.pdf"));
        document.open();
        Anchor anchorTarget = new Anchor("First page of the document.");
        anchorTarget.setName("BackToTop");
        Paragraph paragraph1 = new Paragraph();
        paragraph1.setSpacingBefore(50);
        paragraph1.add(anchorTarget);
        document.add(paragraph1);
        BaseFont baseFont = BaseFont.createFont("C:\\Users\\1\\Documents\\arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font font = new Font(baseFont);

        document.add(new Paragraph("Some more text on the first page with different color and font type.",
                FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 255, 0, 0))));

        Paragraph title1 = new Paragraph("1111",
                FontFactory.getFont(FontFactory.HELVETICA, 14, new CMYKColor(0, 255, 255, 17)));
        Chapter chapter1 = new Chapter(title1, 1);
        chapter1.setNumberDepth(0);

        Paragraph title11 = new Paragraph("Наименование предмета", font);
        Section section1 = chapter1.addSection(title11);
        Paragraph someSectionText = new Paragraph("Дата",font);
        section1.add(someSectionText);
        someSectionText = new Paragraph("Домашка",font);
        section1.add(someSectionText);

        document.add(section1);

        document.close();
    }
}
