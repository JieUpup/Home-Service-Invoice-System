package service.view;


import service.model.*;
import utils.SpringUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;


public class ShowQuotePriceForEachService extends BasicView {
    private static final String[] SHOW_EACH_SERVICE_FEE = {"Clean Fee", "Electrical Service Fee", "Washing Fee",
            "Garden Fee", "Painting Fee"};

    private JTextField cleanFee;
    private JTextField electricalFee;
    private JTextField washingFee;
    private JTextField gardenFee;
    private JTextField paintingFee;

    private JPanel panel;
    private JLabel outputLabel1;


    private CleanInsideService cleanService;
    private ElectricalService electricalService;
    private ExteriorWindowWashingService exteriorWindowWashingService;
    private GardeningService gardeningService;
    private InteriorPaintService interiorPaintService;

    public JPanel getShowPriceJPanel() {
        int numPairs = SHOW_EACH_SERVICE_FEE.length;

        JTextField[] textFields = new JTextField[numPairs];

        panel = new JPanel(new SpringLayout());
        for (int i = 0; i < numPairs; i++) {
            JLabel label = new JLabel(SHOW_EACH_SERVICE_FEE[i], JLabel.TRAILING);
            panel.add(label);


            textFields[i] = new JTextField(10);
            label.setLabelFor(textFields[i]);
            panel.add(textFields[i]);

        }

        cleanFee = textFields[0];
        cleanFee.setText("" + cleanService.serviceFee());

        electricalFee = textFields[1];
        electricalFee.setText("" + electricalService.serviceFee());

        washingFee = textFields[2];
        washingFee.setText("" + exteriorWindowWashingService.serviceFee());

        gardenFee = textFields[3];
        gardenFee.setText("" + gardeningService.serviceFee());

        paintingFee = textFields[4];
        paintingFee.setText("" + interiorPaintService.serviceFee());


        SpringUtilities.makeCompactGrid(panel,
                numPairs, 2,
                6, 6,
                6, 6);

        return panel;
    }

    @Override
    public JPanel getView() {
       /* setLayout(new GridLayout(0, 1));
        add(getShowPriceJPanel());
       // add(getContinueButtonPanel());

        outputLabel1 = new JLabel();
        outputLabel1.setSize(600, 50);
        add(outputLabel1);

        */


        setLayout(new BorderLayout());
        add(getShowPriceJPanel(), BorderLayout.NORTH);
        add(getContinueButtonPanel(), BorderLayout.SOUTH);
        return this;


    }

    public ShowQuotePriceForEachService() {


    }

    private JButton getContinueButtonPanel() {
        JButton serviceButton = new JButton("Continue");

        serviceButton.setSize(2, 4);
        serviceButton.setBackground(Color.green);

        serviceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("Dear Custom: ");
                System.out.println("Here is your pre-invoice:");

                PrinterJob job = PrinterJob.getPrinterJob();
                ArrayList<String> output = new ArrayList<>();
                output.add("Here is your service fee estimation:");
                output.add("Clean service fee: " + cleanService.serviceFee() + "\n\r");
                output.add("Electrical service fee: " + electricalService.serviceFee() + "\n\r");
                output.add("External Window washing service fee: " + exteriorWindowWashingService.serviceFee() + "\n\r");
                output.add("Gardening service fee: " + gardeningService.serviceFee() + "\n\r");
                output.add("Interior paint service fee: " + interiorPaintService.serviceFee() + "\n\r");
                output.add("Your real invoice is a specific number that around prev-invoice 20% percent.") ;
                output.add ("You can confirm your service type and details by contact the company" );

                System.out.println(output);
                job.setPrintable(new PrintInvoice(output));
                boolean ok = job.printDialog();
                if (ok) {
                    try {
                        job.print();
                    } catch (PrinterException ex) {
                        /* The job did not successfully complete */
                    }
                }
            }
        });

        return serviceButton;
    }



    public CleanInsideService getCleanService() {
        return cleanService;
    }

    public void setCleanService(CleanInsideService cleanService) {
        this.cleanService = cleanService;
    }

    public ElectricalService getElectricalService() {
        return electricalService;
    }

    public void setElectricalService(ElectricalService electricalService) {
        this.electricalService = electricalService;
    }

    public ExteriorWindowWashingService getExteriorWindowWashing() {
        return exteriorWindowWashingService;
    }

    public void setExteriorWindowWashing(ExteriorWindowWashingService exteriorWindowWashingService) {
        this.exteriorWindowWashingService = exteriorWindowWashingService;
    }

    public GardeningService getGardening() {
        return gardeningService;
    }

    public void setGardening(GardeningService gardeningService) {
        this.gardeningService = gardeningService;
    }

    public InteriorPaintService getInteriorPaint() {
        return interiorPaintService;
    }

    public void setInteriorPaint(InteriorPaintService interiorPaintService) {
        this.interiorPaintService = interiorPaintService;
    }

    public JLabel getOutputLabel1() {
        return outputLabel1;
    }
}



