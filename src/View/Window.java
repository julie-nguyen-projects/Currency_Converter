package View;

import Model.Currency;
import View.Buttons.ActionButton;
import View.Buttons.InputButton;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Window extends JFrame {

    private JPanel outputPanel = new JPanel();
    private JPanel inputPanel = new JPanel();
    private JScrollPane scrollPane = new JScrollPane(outputPanel);
    private ArrayList<InputButton> inputButtons = new ArrayList<>();


    public JPanel getOutputPanel() {
        return outputPanel;
    }

    public JPanel getInputPanel() {
        return inputPanel;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }



    public Window() throws HeadlessException {
        super("Currency converter");
        this.setSize(600, 900);
        this.setVisible(true);
        this.setResizable(false);

        initComponents();

        this.add(scrollPane, BorderLayout.CENTER);
        this.add(inputPanel, BorderLayout.SOUTH);

    }

    public void displayCurrencies(ArrayList<Currency> currencies) {
        if (currencies.size() == 1) {
            // Ligne sans croix
            JPanel linePanel = new JPanel();
            linePanel.setPreferredSize(new Dimension(590, 75));
            // croix disabled = action button x
            ActionButton xButton = new ActionButton("x");
            xButton.setEnabled(false);
            xButton.setPreferredSize(new Dimension(60,60));

            // currency name
            JLabel label = new JLabel(currencies.get(0).getName());
            label.setPreferredSize(new Dimension(150, 60));

            // currency input = currency button
            InputButton inputButton = new InputButton("0");
            inputButton.setPreferredSize(new Dimension(150, 60));

            // currency image
            JLabel image = new JLabel(new ImageIcon("../Currency_Converter/src/euro.png"));
            image.setPreferredSize(new Dimension(60,60));

            // action button +
            ActionButton plusButton = new ActionButton("+");
            plusButton.setPreferredSize(new Dimension(60,60));

            linePanel.add(xButton);
            linePanel.add(label);
            linePanel.add(inputButton);
            linePanel.add(image);
            linePanel.add(plusButton);

            outputPanel.add(linePanel);
        } else {
            // Lignes complètes
            for (Currency currency : currencies) {

            }
        }
    }


    private void initComponents() {
        scrollPane.setPreferredSize(new Dimension(600, 600));
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        inputPanel.setPreferredSize(new Dimension(600, 300));

        initInputButtons();


    }

    private void initInputButtons() {
        JPanel sevenToNinePanel = new JPanel();
        JPanel fourToSixPanel = new JPanel();
        JPanel oneToThreePanel = new JPanel();
        JPanel specialCharPanel = new JPanel();
        JPanel aroundCharPanel = new JPanel();

        inputButtons.add(new InputButton("7"));
        inputButtons.add(new InputButton("8"));
        inputButtons.add(new InputButton("9"));
        inputButtons.add(new InputButton("4"));
        inputButtons.add(new InputButton("5"));
        inputButtons.add(new InputButton("6"));
        inputButtons.add(new InputButton("1"));
        inputButtons.add(new InputButton("2"));
        inputButtons.add(new InputButton("3"));
        inputButtons.add(new InputButton("0"));
        inputButtons.add(new InputButton("."));
        inputButtons.add(new InputButton("C"));

        for (int i = 0 ; i < inputButtons.size() ; i ++) {
            if (i < 3) {
                sevenToNinePanel.add(inputButtons.get(i));
            } else if (i < 6) {
                fourToSixPanel.add(inputButtons.get(i));
            } else if (i < 9) {
                oneToThreePanel.add(inputButtons.get(i));
            } else {
                specialCharPanel.add(inputButtons.get(i));
            }
        }

        sevenToNinePanel.setPreferredSize(new Dimension(225,60));
        fourToSixPanel.setPreferredSize(new Dimension(225,60));
        oneToThreePanel.setPreferredSize(new Dimension(225,60));
        specialCharPanel.setPreferredSize(new Dimension(225,60));

        aroundCharPanel.add(sevenToNinePanel);
        aroundCharPanel.add(fourToSixPanel);
        aroundCharPanel.add(oneToThreePanel);
        aroundCharPanel.add(specialCharPanel);

        aroundCharPanel.setPreferredSize(new Dimension(200, 280));

        JPanel leftCharPanel = new JPanel();
        JPanel rightCharPanel = new JPanel();
        leftCharPanel.setSize(new Dimension(30, 300));
        //rightCharPanel.setPreferredSize(new Dimension(38, 300));
        inputPanel.add(leftCharPanel);
        inputPanel.add(aroundCharPanel);
        inputPanel.add(rightCharPanel);
    }
}
