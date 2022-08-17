package service.view;


import java.awt.Graphics2D;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PrintInvoice implements Printable {
    private ArrayList<String> texts;
    public PrintInvoice(ArrayList<String> texts) {
        this.texts = texts;
    }


    public int print(Graphics g, PageFormat pf, int page) throws
            PrinterException {

        if (page > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }

        /* User (0,0) is typically outside the imaginable area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         */
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());

        /* Now we perform our rendering */
        for (int i = 0; i < texts.size(); i++) {
            g.drawString(texts.get(i), 100 , 100 + 20*i);
        }

        /* tell the caller that this page is part of the printed document */
        return PAGE_EXISTS;
    }
}
