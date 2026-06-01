package parking_system.controller;

import com.itextpdf.text.Document;

import com.itextpdf.text.Paragraph;

import com.itextpdf.text.pdf.PdfWriter;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;

@RestController

public class PdfController {

    @GetMapping("/generate-pdf")

    public String generatePdf() {

        try {

            Document document =
                    new Document();

            PdfWriter.getInstance(
                    document,

                    new FileOutputStream(
                            "vehicle_receipt.pdf"
                    )
            );

            document.open();

            document.add(
                    new Paragraph(
                            "Secure Parking System Receipt"
                    )
            );

            document.add(
                    new Paragraph(
                            "Vehicle : CAR999"
                    )
            );

            document.add(
                    new Paragraph(
                            "Slot : A01"
                    )
            );

            document.add(
                    new Paragraph(
                            "Payment : Rs. 500"
                    )
            );

            document.close();

            return "PDF Generated Successfully";

        } catch (Exception e) {

            return e.getMessage();
        }
    }
}