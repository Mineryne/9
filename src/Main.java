import java.awt.event.*;
import javax.swing.*;
public class Main {
    public static void main(String[] args) {



        class ButtonModel {
            private String buttonText;

            public String getButtonText() {
                return buttonText;
            }

            public void setButtonText(String text) {
                buttonText = text;
            }
        }


        class ButtonModelOne extends ButtonModel {
            public ButtonModelOne() {
                setButtonText("Button One");
            }
        }


        class ButtonModelTwo extends ButtonModel {
            public ButtonModelTwo() {
                setButtonText("Button Two");
            }
        }


        class ButtonView extends JFrame {
            private JButton button;

            public ButtonView(Controller controller) {
                setTitle("MVC Button Example");
                setSize(300, 200);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                button = new JButton(controller.getModel().getButtonText());
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        controller.buttonClick();
                    }
                });

                getContentPane().add(button);
                setVisible(true);
            }

            public void updateButtonText(String newText) {
                button.setText(newText);
            }
        }


        class Controller {
            private ButtonModel model;
            private ButtonView view;

            public Controller(ButtonModel model, ButtonView view) {
                this.model = model;
                this.view = view;
            }

            public ButtonModel getModel() {
                return model;
            }

            public void buttonClick() {

                if (model instanceof ButtonModelOne) {
                    model.setButtonText("Clicked One");
                } else if (model instanceof ButtonModelTwo) {
                    model.setButtonText("Clicked Two");
                }
                view.updateButtonText(model.getButtonText());
            }
        }

        class Main2 {
            public static void main(String[] args) {

                ButtonModelOne modelOne = new ButtonModelOne();
                ButtonView viewOne = new ButtonView(new Controller(modelOne, viewOne));

                ButtonModelTwo modelTwo = new ButtonModelTwo();
                ButtonView viewTwo = new ButtonView(new Controller(modelTwo, viewTwo));
            }
        }

    }
}
