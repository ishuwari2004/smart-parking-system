package parking_system.controller;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.qrcode.QRCodeWriter;

import com.google.zxing.common.BitMatrix;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

import java.io.File;

@RestController

public class QrController {

    @GetMapping("/generate-qr")

    public String generateQr() {

        try {

            String data = "Vehicle : CAR999";

            QRCodeWriter qrCodeWriter =
                    new QRCodeWriter();

            BitMatrix bitMatrix =
                    qrCodeWriter.encode(
                            data,
                            BarcodeFormat.QR_CODE,
                            300,
                            300
                    );

            BufferedImage image =
                    new BufferedImage(
                            300,
                            300,
                            BufferedImage.TYPE_INT_RGB
                    );

            for (int x = 0; x < 300; x++) {

                for (int y = 0; y < 300; y++) {

                    image.setRGB(
                            x,
                            y,
                            bitMatrix.get(x, y)
                                    ? 0x000000
                                    : 0xFFFFFF
                    );
                }
            }

            File outputFile =
                    new File("vehicle_qr.png");

            ImageIO.write(
                    image,
                    "png",
                    outputFile
            );

            return "QR Code Generated Successfully";

        } catch (Exception e) {

            return e.getMessage();
        }
    }
}