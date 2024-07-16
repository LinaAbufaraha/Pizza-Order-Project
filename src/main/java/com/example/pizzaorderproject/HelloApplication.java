package com.example.pizzaorderproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ArrayList<PizzaOrder> orders = new ArrayList<>();
        orders.add(new Delivery("Ahmad",PizzaOrder.LARGE,3,10,10,3));
        Collections.sort(orders);
        BorderPane BPane = new BorderPane();
        Image image = new Image("file:C:\\Users\\Lenovo\\OneDrive\\Pictures\\a04a4947-741f-417a-97dd-e11f45284d05.jpeg");

        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, true, false);

        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, backgroundSize);

        Background background = new Background(backgroundImage);

        StackPane pane = new StackPane();
        pane.setBackground(background);

        GridPane root= new GridPane();
        root.setHgap(20);
        root.setVgap(20);

        Scene scene = new Scene(pane, 500, 750);

        Label customerName=new Label("Customer Name :");
        customerName.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        TextField TFcustomerName =new TextField();
        root.add(customerName,0,0);
        root.add(TFcustomerName,1,0);

        Label orderType =new Label("OrderType :");
        orderType.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        ComboBox<String> CBorderType= new ComboBox<>();
        CBorderType.getItems().addAll("To go","Delivery","Seated");
        CBorderType.getSelectionModel().select(0);
        root.add(orderType,0,1);
        root.add(CBorderType,1,1);

        Label pizzaSize =new Label("pizza Size :");
        pizzaSize.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        RadioButton RBSSize = new RadioButton("SMALL");
        RadioButton RBMSize = new RadioButton("MEDIUM");
        RadioButton RBLSize = new RadioButton("LARGE");

        ToggleGroup groupSize=new ToggleGroup();
        RBSSize.setToggleGroup(groupSize);
        RBMSize.setToggleGroup(groupSize);
        RBLSize.setToggleGroup(groupSize);
        RBSSize.setSelected(true);

        HBox root1 = new HBox(5);
        root1.getChildren().addAll(RBSSize,RBMSize,RBLSize);

        root.add(pizzaSize,0,2);
        root.add(root1,1,2);

        Label ListofToppings  =new Label("List of Toppings :");
        ListofToppings.setFont(Font.font("Arial", FontWeight.BOLD, 14));

        CheckBox T1 = new CheckBox("Onions ");
        CheckBox T2 = new CheckBox("Olives ");
        CheckBox T3 = new CheckBox("Green Peppers ");
        HBox root2 = new HBox(4);
        root2.getChildren().addAll(T1,T2,T3);
        root.add(ListofToppings,0,3);
        root.add(root2,1,3);


        Label tripRate =new Label("trip Rate");
        tripRate.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        TextField TFtripRate=new TextField();
        Label zone =new Label("zone");
        zone.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        TextField TFzone=new TextField();

        root.add(tripRate,0,4);
        root.add(TFtripRate,1,4);
        root.add(zone,0,5);
        root.add(TFzone,1,5);

        Label serviceCharge =new Label("Service Charge");
        serviceCharge.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        TextField TFserviceCharge=new TextField();
        Label numberOfPeople  =new Label("Number Of People ");
        numberOfPeople.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        TextField TFnumberOfPeople =new TextField();

        root.add(serviceCharge,0,6);
        root.add(TFserviceCharge,1,6);
        root.add(numberOfPeople,0,7);
        root.add(TFnumberOfPeople,1,7);

        Label toppingPrice  =new Label("Topping Price :");
        toppingPrice.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        root.add(toppingPrice,0,8);
        TextField topPrice =new TextField();
        topPrice.setText("10");
        root.add(topPrice,1,8);

        tripRate.setVisible(false);
        TFtripRate.setVisible(false);
        zone.setVisible(false);
        TFzone.setVisible(false);
        serviceCharge.setVisible(false);
        TFserviceCharge.setVisible(false);
        numberOfPeople.setVisible(false);
        TFnumberOfPeople.setVisible(false);

        CBorderType.setOnAction(e -> {
            if(CBorderType.getSelectionModel().isSelected(0)) {
                tripRate.setVisible(false);
                TFtripRate.setVisible(false);
                zone.setVisible(false);
                TFzone.setVisible(false);
                serviceCharge.setVisible(false);
                TFserviceCharge.setVisible(false);
                numberOfPeople.setVisible(false);
                TFnumberOfPeople.setVisible(false);

            }else
            if(CBorderType.getSelectionModel().isSelected(1)){
                stage.show();
                tripRate.setVisible(true);
                TFtripRate.setVisible(true);
                zone.setVisible(true);
                TFzone.setVisible(true);
                serviceCharge.setVisible(false);
                TFserviceCharge.setVisible(false);
                numberOfPeople.setVisible(false);
                TFnumberOfPeople.setVisible(false);

            }else
            if(CBorderType.getSelectionModel().isSelected(2)) {
                stage.show();
                tripRate.setVisible(false);
                TFtripRate.setVisible(false);
                zone.setVisible(false);
                TFzone.setVisible(false);
                serviceCharge.setVisible(true);
                TFserviceCharge.setVisible(true);
                numberOfPeople.setVisible(true);
                TFnumberOfPeople.setVisible(true);

            }
        });

        Label orderPrice  =new Label("Order Price :");
        orderPrice.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        TextField TFordPrice =new TextField();
        TFordPrice.setText("0.0");
        root.add(orderPrice,0,9);
        root.add(TFordPrice,1,9);

        Button processOrder = new Button("Process Order");
        Button printOrders = new Button("Print Orders");
        Button reset = new Button("Reset");
        HBox root3 = new HBox(6);
        root3.getChildren().addAll(processOrder,printOrders,reset);
        //root.add(root3,1,10);
        BPane.setBottom(root3);
        root3.setAlignment(Pos.CENTER);
        root.setAlignment(Pos.CENTER);

        GridPane root4 = new GridPane();
        root4.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
        root4.setHgap(20);
        root4.setVgap(20);
        root4.setAlignment(Pos.TOP_CENTER);
        Stage stage3 = new Stage();
        printOrders.addEventHandler(ActionEvent.ACTION, (e) ->{
            try{
                Text Title = new Text();
                Title.setFont(Font.font("Abyssinica SIL", FontWeight.BOLD, FontPosture.REGULAR,20));
                Title.setText("Orders List:");
                root4.add(Title,0,0);
                for (int i = 0; i < orders.size(); i++) {
                    Label name1 = new Label("Customer Name:");
                    Label name2 = new Label(orders.get(i).getCustomerName());
                    Label order1 = new Label("Order Price:");
                    Label order2 = new Label(String.valueOf(orders.get(i).calculateOrderPrice()));
                    root4.add(name1,0,i+1);
                    root4.add(name2,1,i+1);
                    root4.add(order1,2,i+1);
                    root4.add(order2,3,i+1);
                }
                stage3.show();

            }catch(Exception ex){
                ex.printStackTrace();
            }
        });
        Scene scene1 = new Scene (root4,400,600,Color.YELLOW);
        stage3.setTitle("Print Orders");
        stage3.setScene(scene1);

        processOrder.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    int size = RBSSize.isSelected() ? 1 : RBMSize.isSelected() ? 2 :3 ;
                    int numberOfTopping = (T1.isSelected() ? 1 : 0) + (T2.isSelected() ? 1 : 0) + (T3.isSelected() ? 1 : 0);
                    double toppingPriceValue = Double.parseDouble(topPrice.getText());

                    switch (CBorderType.getSelectionModel().getSelectedIndex()) {
                        case 0: // To go
                            ToGo toGoOrder = new ToGo(TFcustomerName.getText(), size, numberOfTopping, toppingPriceValue);
                            orders.add(toGoOrder);
                            TFordPrice.setText(String.valueOf(toGoOrder.calculateOrderPrice()));
                            break;
                        case 1: // Delivery
                            double tripRateValue = Double.parseDouble(TFtripRate.getText());
                            int zoneValue = Integer.parseInt(TFzone.getText());
                            Delivery deliveryOrder = new Delivery(TFcustomerName.getText(), size, numberOfTopping, toppingPriceValue, tripRateValue, zoneValue);
                            orders.add(deliveryOrder);
                            TFordPrice.setText(String.valueOf(deliveryOrder.calculateOrderPrice()));
                            break;
                        case 2: // Seated
                            double serviceChargeValue = Double.parseDouble(TFserviceCharge.getText());
                            int numberOfPeopleValue = Integer.parseInt(TFnumberOfPeople.getText());
                            Seated seatedOrder = new Seated(TFcustomerName.getText(), size, numberOfTopping, toppingPriceValue, serviceChargeValue, numberOfPeopleValue);
                            orders.add(seatedOrder);
                            TFordPrice.setText(String.valueOf(seatedOrder.calculateOrderPrice()));
                            break;
                    }
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                    showAlert("Error", "Invalid input. Please enter valid numbers.");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    showAlert("Error", "An unexpected error occurred: " + ex.getMessage());
                }
            }
        });

        reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TFcustomerName.clear();
                CBorderType.getSelectionModel().select(0);
                RBLSize.setSelected(true);
                T1.setSelected(false);
                T2.setSelected(false);
                T3.setSelected(false);
                TFtripRate.clear();
                TFtripRate.setVisible(false);
                TFzone.clear();
                TFzone.setVisible(false);
                TFserviceCharge.clear();
                TFserviceCharge.setVisible(false);
                TFnumberOfPeople.clear();
                TFnumberOfPeople.setVisible(false);
                topPrice.setText("10");
                TFordPrice.setText("0.0");
                orders.clear();
            }
        });

        Text Title = new Text();
        Title.setFont(Font.font("Abyssinica SIL", FontWeight.BOLD, FontPosture.REGULAR,22));
        Title.setFill(Color.WHITE);
        Title.setStroke(Color.BLACK);
        Title.setStrokeWidth(1);
        Title.setText("\n        Welcome to my pizza ordering app: ");

        BPane.setCenter(root);
        BPane.setTop(Title);
        pane.getChildren().addAll(BPane);

        stage.setTitle("Pizza Order Application");
        stage.setScene(scene);
        stage.show();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();

    }

}