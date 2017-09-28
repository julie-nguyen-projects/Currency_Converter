package View;

import Model.Currency;
import View.Buttons.ActionButton;
import View.Buttons.CurrencyButton;
import View.Buttons.InputButton;

import javax.swing.*;
import javax.swing.border.LineBorder;
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
        this.setResizable(false);

        initComponents();

        this.add(scrollPane, BorderLayout.CENTER);
        this.add(inputPanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public void displayCurrencies(ArrayList<Currency> currencies) {
        outputPanel.setPreferredSize(new Dimension(600, 75 * currencies.size()));
        for (Currency currency : currencies) {
            JPanel linePanel = new JPanel();
            linePanel.setPreferredSize(new Dimension(590, 75));
            // croix disabled = action button x
            ActionButton xButton = new ActionButton("x");
            // Ligne sans croix
            if (currencies.size() == 1) {
                xButton.setEnabled(false);
                xButton.setBackground(new Color(200, 220, 255));
            }

            // border
            LineBorder line = new LineBorder(Color.lightGray, 3, true);

            // currency name
            JLabel label = new JLabel(currency.getName());
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setPreferredSize(new Dimension(150, 60));
            label.setBorder(line);
            label.setOpaque(true);
            label.setBackground(new Color(224, 224, 209));

            // currency input = currency button
            CurrencyButton inputButton = new CurrencyButton();

            // currency image
            CurrencyLabel image = new CurrencyLabel(currencies.get(0).getName());

            // action button +
            ActionButton plusButton = new ActionButton("+");
            plusButton.setPreferredSize(new Dimension(60, 60));

            linePanel.add(xButton);
            linePanel.add(label);
            linePanel.add(inputButton);
            linePanel.add(image);
            linePanel.add(plusButton);

            outputPanel.add(linePanel);
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

        for (int i = 0; i < inputButtons.size(); i++) {
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

        sevenToNinePanel.setPreferredSize(new Dimension(225, 60));
        fourToSixPanel.setPreferredSize(new Dimension(225, 60));
        oneToThreePanel.setPreferredSize(new Dimension(225, 60));
        specialCharPanel.setPreferredSize(new Dimension(225, 60));


        aroundCharPanel.add(sevenToNinePanel);
        aroundCharPanel.add(fourToSixPanel);
        aroundCharPanel.add(oneToThreePanel);
        aroundCharPanel.add(specialCharPanel);

        aroundCharPanel.setPreferredSize(new Dimension(200, 280));

        JPanel leftCharPanel = new JPanel();
        leftCharPanel.setBackground(new Color(224, 224, 209));

        JPanel rightCharPanel = new JPanel();
        rightCharPanel.setBackground(new Color(224, 224, 209));
        leftCharPanel.setSize(new Dimension(30, 300));
        //rightCharPanel.setPreferredSize(new Dimension(38, 300));
        inputPanel.add(leftCharPanel);
        inputPanel.add(aroundCharPanel);
        inputPanel.add(rightCharPanel);
        inputPanel.setBackground(new Color(224, 224, 209));
    }
}
