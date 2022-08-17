package service.view;

import service.model.*;
import utils.SpringUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServiceInformationWindow extends BasicView {
    private static final String[] ENTER_SERVICE_INFO = {"Address", "SIZE(SMALL/MEDIUM/LARGE)", "Number Of Floor",
            "Number Of Pet", "Monthly User(Y/N)"};
    private JTextField addressTextField;
    private JTextField sizeTextField;
    private JTextField numberOfFloorTextField;

    private JTextField numberOfPetTextField;

    private JTextField monthlyUserOrNotTextField;

    private CleanInsideService cleanService;
    private ElectricalService electricalService;
    private ExteriorWindowWashingService exteriorWindowWashingService;
    private GardeningService gardeningService;
    private InteriorPaintService interiorPaintService;

    private JTextField cleanFee;



    public JPanel getEnterServiceInformationPanel() {
        int numPairs = ENTER_SERVICE_INFO.length;

        JTextField [] textFields = new JTextField[numPairs];



        JPanel enterServiceInformationPanel = new JPanel(new SpringLayout());
        enterServiceInformationPanel.setBackground(COLOR_WINDOW);

        for (int i = 0; i < numPairs; i++) {
            JLabel label = new JLabel(ENTER_SERVICE_INFO[i], JLabel.TRAILING);
            label.setBackground(COLOR_BACKGROUND);
            label.setBounds(2,3,10,4);

            enterServiceInformationPanel.add(label);

            JTextField textField = new JTextField(10);
            label.setLabelFor(textField);
            enterServiceInformationPanel.add(textField);
            textFields[i] = textField;
            textField.setBackground(COLOR_TEXT_FIELD);

        }
        addressTextField = textFields[0];
        addressTextField.setBackground(COLOR_TEXT_FIELD);

       sizeTextField= textFields[1];
       sizeTextField.setBackground(COLOR_TEXT_FIELD);


       numberOfFloorTextField = textFields[2];
        numberOfFloorTextField.setBackground(COLOR_TEXT_FIELD);

       numberOfPetTextField = textFields[3];
       numberOfPetTextField.setBackground(COLOR_TEXT_FIELD);
       monthlyUserOrNotTextField = textFields[4];
       monthlyUserOrNotTextField.setBackground(COLOR_TEXT_FIELD);

        SpringUtilities.makeCompactGrid(enterServiceInformationPanel,
                numPairs, 2,
                6, 6,
                6, 6);

        return enterServiceInformationPanel;
    }

    public void setInteriorPaint(InteriorPaintService interiorPaintService) {
        this.interiorPaintService = interiorPaintService;
    }

    public void setGardening(GardeningService gardeningService) {
        this.gardeningService = gardeningService;
    }

    public void setExteriorWindowWashing(ExteriorWindowWashingService exteriorWindowWashingService) {
        this.exteriorWindowWashingService = exteriorWindowWashingService;
    }

    public void setElectricalService(ElectricalService electricalService) {
        this.electricalService = electricalService;
    }

    public void setCleanFee(JTextField cleanFee) {
        this.cleanFee = cleanFee;
    }

    public JTextField getCleanFee() {
        return cleanFee;
    }

    public InteriorPaintService getInteriorPaint() {
        return interiorPaintService;
    }

    public GardeningService getGardening() {
        return gardeningService;
    }

    public CleanInsideService getCleanService() {
        return cleanService;
    }

    public ExteriorWindowWashingService getExteriorWindowWashing() {
        return exteriorWindowWashingService;
    }

    public ElectricalService getElectricalService() {
        return electricalService;
    }

    public JTextField getAddressTextField() {
        return addressTextField;
    }

    public JTextField getMonthlyUserOrNotTextField() {
        return monthlyUserOrNotTextField;
    }

    public ServiceInformationWindow() {

    }

    @Override
    public JPanel getView() {
        setLayout(new BorderLayout());
        add(getEnterServiceInformationPanel(), BorderLayout.NORTH);
        add(getConfirmButtonPanel(), BorderLayout.SOUTH);

        return this;
    }

    private JButton getConfirmButtonPanel() {
        TextArea txt = new TextArea("Introduction");
        txt.setText("here is the information when you enter your password and id" +"");
        JButton confirmButton = new JButton("CONFIRM");
        confirmButton.setBackground(COLOR_BUTTON);
        confirmButton.setBounds(10,20,30,50);
        confirmButton.setSize(40, 20);




        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(addressTextField.getText());
                System.out.println(sizeTextField.getText());
                System.out.println(numberOfFloorTextField.getText());
                System.out.println(numberOfPetTextField.getText());
                System.out.println(monthlyUserOrNotTextField.getText());

                String  monthlyUserYesOrNo = monthlyUserOrNotTextField.getText();
                boolean monthlyUserBool = false;
                if (monthlyUserYesOrNo.toLowerCase().equals("Y")
                        || monthlyUserYesOrNo.toLowerCase().equals("YES")) {
                    monthlyUserBool = true;
                }

                HouseSize houseSize = HouseSize.valueOf(sizeTextField.getText().toUpperCase());

                cleanService = new CleanInsideService(
                        houseSize,
                        addressTextField.getText(),
                        Integer.parseInt(numberOfFloorTextField.getText()),
                        Integer.parseInt(numberOfPetTextField.getText()),
                        0,
                        monthlyUserBool);


                System.out.println("Clean fee: " + cleanService.serviceFee());

                electricalService = new ElectricalService(houseSize,
                        addressTextField.getText(), false, 2, false);
                System.out.println("Electrical service fee is : " + electricalService.serviceFee());

                exteriorWindowWashingService = new ExteriorWindowWashingService(HouseSize.valueOf(sizeTextField.getText()),
                        addressTextField.getText(), 1, 1,0,false,false);

                System.out.println("Washing fee: " + exteriorWindowWashingService.serviceFee());


                gardeningService = new GardeningService(houseSize,
                        addressTextField.getText(),false,false);

                System.out.println("Garden fee:   " + gardeningService.serviceFee());

                interiorPaintService = new InteriorPaintService(houseSize,
                        addressTextField.getText(),1,1);
                System.out.println("Painting fee:   " + interiorPaintService.serviceFee());

                Main.feeView.setCleanService(cleanService);
                Main.feeView.setGardening(gardeningService);
                Main.feeView.setElectricalService(electricalService);
                Main.feeView.setExteriorWindowWashing(exteriorWindowWashingService);
                Main.feeView.setInteriorPaint(interiorPaintService);

                Main.serviceView.setVisible(false);
                Main.window.add(Main.feeView.getView());
                Main.window.setTitle("Show Quote Price for Each Service");


            }
        });

        return confirmButton;
    }
}

