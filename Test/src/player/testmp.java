//package player;
//
//import javafx.animation.KeyFrame;
//import javafx.animation.KeyValue;
//import javafx.animation.Timeline;
//import javafx.application.Application;
//import javafx.application.Platform;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.NodeOrientation;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.control.Button;
//import javafx.scene.control.TextField;
//import javafx.scene.input.MouseButton;
//import javafx.scene.input.MouseEvent;
//
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.HBox;
//
//import javafx.scene.layout.VBox;
//import javafx.scene.media.AudioSpectrumListener;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//import javafx.scene.media.MediaView;
//import javafx.scene.paint.Color;
//import javafx.stage.FileChooser;
//import javafx.stage.Stage;
//import javafx.util.Duration;
//import javafx.scene.shape.Rectangle;
//
//import javax.imageio.ImageIO;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//
//
//
//public class testmp extends Application{
//   
//    public static void main(String[] args)
//    {
//       
//        launch(args);
//    }
//
//    FileChooser choose=new FileChooser();
//    File file;
//    @Override
//    public void start(Stage stage) throws Exception {
//         String fileplay = "file:///C:/CUSTOM%20INSTALLATIONS/What%20is%20Tomcat%20Server.mp4";
//       
//        stage.setTitle("Media Player"); //sets a title for the stage or for the window
//        Group root = new Group();  //creating a group
//         
//
//
//        final   Button b1=new Button("Mute");
//        b1.setDisable(false);
//        final Button b=new Button("Pause");
//        b.setDisable(false);
//        final Button b2=new Button("Fullscreen");
//        b2.setDisable(false);
//        final Button b3=new Button("Screenshot");
//        final TextField text = new TextField();
//        text.setEditable(false);
//        final HBox hbox = new HBox(2); //hbox creates a horizontal spacing of 2
//       
//        GridPane gridPane=new GridPane();
//            gridPane.add(b,300,2);
//        gridPane.add(b1,350,2);
//        gridPane.add(b2,250,2);
//        gridPane.add(b3,280,2);
//       gridPane.add(text, 500, 1);
//       
//        hbox.getChildren().add(gridPane);
//              
//
//        if (fileplay.equals("file:///C:/CUSTOM%20INSTALLATIONS/What%20is%20Tomcat%20Server.mp4")) {
//
//            file=choose.showOpenDialog(stage);
//
//            fileplay="file://" + file.toString();
//        }
//
//        
//
//        Media media = new Media(fileplay); //reading a media file
//        final MediaPlayer player = new MediaPlayer(media);  //creates a player for a specific media
//        MediaView view = new MediaView(player);// associated with the player
//        Scene scene = new Scene(root, 200, 400, Color.BLACK);  //adding group to scene and window color is black
//        scene.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
//
//     
//
//
//        b.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                if (b.getText().equals("Pause")) {
//                    player.pause();
//                    b.setText("Play");
//                } else {
//                    player.play();
//                    b.setText("Pause");
//                }
//            }
//        });
//
//
//        b1.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//
//                if (b1.getText().equals("Mute")) {
//                    player.setMute(true);
//                    b1.setText("Unmute");
//                } else {
//                    player.setMute(false);
//                    b1.setText("Mute");
//                }
//            }
//        });
//
//
//        b2.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                if (b2.getText().equals("Fullscreen")) {
//                    stage.setFullScreen(true);
//                    b2.setText("Minimize");
//                } else {
//                    stage.setFullScreen(false);
//                    b2.setText("Fullscreen");
//                }
//            }
//        });
//
//        b3.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//              try {
//                  Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
//                  Robot rt = new Robot();
//                  BufferedImage img = rt.createScreenCapture(new java.awt.Rectangle((int) screen
//                          .getWidth(), (int) screen.getHeight()));
//                  ImageIO.write(img, "jpeg", new File(System.currentTimeMillis()
//                          + ".jpeg"));
//              }
//              catch (Exception e)
//              {}
//            }
//        });
//
//        final Timeline SlideIn = new Timeline();  //timeline creates a free form of animation
//        final Timeline SlideOut = new Timeline();
//        root.setOnMouseExited(new EventHandler<MouseEvent>() {    //defines function to be called when mouse exits this node
//            @Override
//            public void handle(MouseEvent event) {
//                SlideOut.pause();
//            }
//        });
//
//        root.setOnMouseEntered(new EventHandler<MouseEvent>() {   //defines function to be called when mouse enters this node
//            @Override
//            public void handle(MouseEvent event) {
//                SlideIn.play();
//            }
//        });
//
//        VBox vbox = new VBox();   //creates a vbox of spacing 0 and alignment as TOP-LEFT
//
//        final Slider slider = new Slider(); //default slider instance with default range and a default value
//        slider.setMaxWidth(1280);
//        vbox.getChildren().add(slider);  //adds the slider into a vbox
//
//        vbox.getChildren().add(hbox);   //adding hbox into vbox
//        root.getChildren().add(view);    //adding mediaview to the group
//        root.getChildren().add(vbox);   //adding vbox to the group
//
//
//        final int bands = player.getAudioSpectrumNumBands();   //gives the total number of bands in an audio spectrum
//        final Rectangle[] rects = new Rectangle[bands];  // creating array of rectangles as many as bands
//        
//        for (int i = 0; i < rects.length; i++) {
//            rects[i] = new Rectangle();           //creating objects of rectangle for every element of rectangle array
//            rects[i].setFill(Color.GREENYELLOW);  //fills the paint into a rectangle
//            hbox.getChildren().add(rects[i]);   //adding the array of rectangle objects into hbox
//        }
//
//        player.setOnReady(new Runnable() {  //sets mediaplayer.status.ready to a runnable value
//            @Override
//            public void run() {
//                int v = player.getMedia().getWidth(); //retrieves the media being played and the width of window
//                int h = player.getMedia().getHeight(); //retrieves the media being played and the height of window
//                stage.setMinWidth(v);  //setting minimum width of the window
//                stage.setMinHeight(h);  //setting minimum height of the window
//
//                hbox.setMinWidth(v);  //setting width of a hbox
//                int bandWith = v / rects.length;  //dividing the total width by length of rectangle
//                for (Rectangle r : rects) {
//                    r.setWidth(bandWith);  //setting width of the rectangle into bandwidth
//                    r.setHeight(2);  //setting height to 2 same as hbox spacing
//                }
//
//                stage.setMinWidth(v);  //
//                stage.setMinHeight(h);  //
//                vbox.setMinSize(v, 100);   // setting min width as v and height as 100
//                vbox.setTranslateY(h - 100);  //defines the y coordinate of the translation that is added to node's transform
//
//                slider.setMin(0.0);
//                slider.setValue(0.0);
//                slider.setMax(player.getTotalDuration().toSeconds()); //setting the slider to max duration of the video
//
//                SlideOut.getKeyFrames().addAll(   //calls keyframes constructor and returns the time,event handler,keyframe valus and add these properties to timeline
//                        new KeyFrame(new Duration(0),
//                                new KeyValue(vbox.translateYProperty(), h - 100),
//                                new KeyValue(vbox.opacityProperty(), 0.9)
//                        ),
//                        new KeyFrame(new Duration(300),
//                                new KeyValue(vbox.translateYProperty(), h),
//                                new KeyValue(vbox.opacityProperty(), 0.0)
//                        )
//                );
//
//                SlideIn.getKeyFrames().addAll(
//                        new KeyFrame(new Duration(0),
//                                new KeyValue(vbox.translateYProperty(), h),
//                                new KeyValue(vbox.opacityProperty(), 0.0)
//                        ),
//                        new KeyFrame(new Duration(300),
//                                new KeyValue(vbox.translateYProperty(), h - 100),
//                                new KeyValue(vbox.opacityProperty(), 0.9)
//                        )
//                );
//            }
//        });
//        final double[] time = new double[1];
//        final int[] displaytime = new int[3];
//        final int[] displaytotaltime=new int[3];
//        final int[] hrtime = new int[1];
//        final int[] mintime = new int[1];
//        //controller
//        player.currentTimeProperty().addListener(new ChangeListener<Duration>() {
//            @Override
//            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
//                time[0] = newValue.toSeconds();
//                displaytime[0] = (int) time[0] % 3600;   hrtime[0] = (int) (time[0]/3600);
//                displaytime[1] = displaytime[0] % 60;     mintime[0] = displaytime[0]/60;
//                displaytime[2] = displaytime[1] % 60;
//
//                int total=(int)media.getDuration().toSeconds();
//                displaytotaltime[0]=total%3600;
//                                                             int hrtotaltime = total / 3600;
//                                                             int mintotaltime=displaytotaltime[0]/60;
//                displaytotaltime[1]=total%60;
//                displaytotaltime[2]=total%60;
//                text.setText(Integer.toString(hrtime[0]) + ":" + Integer.toString(mintime[0]) + ":" + Integer.toString(displaytime[2])+"/"+Integer.toString(hrtotaltime)+":"+Integer.toString(mintotaltime)+":"+Integer.toString(displaytotaltime[2]));
//                slider.setValue(time[0]);   //setting the value to current time when video is forwarded
//            }
//        });
//
//      
//
//        stage.setScene(scene); //setting scene using stage
//        stage.show(); //to show the stage
//        player.play();  //to play the video
//
//        slider.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//              if(event.getButton().equals(MouseButton.PRIMARY))
//               { player.seek(Duration.seconds(slider.getValue()));}
//            }  //changing the video to the current time
//        });
//
//        player.setAudioSpectrumListener(new AudioSpectrumListener() {
//            @Override
//            public void spectrumDataUpdate(double timestamp, double duration, float[] magnitudes, float[] phases) {
//                for (int i = 0; i < rects.length; i++) {
//                    double h = magnitudes[i] + 60;
//                    if (h > 2) {
//                        rects[i].setHeight(h);
//                    }
//                }
//            }
//        });   //representing the sound in the form of an bar graph
//    }
//
//}