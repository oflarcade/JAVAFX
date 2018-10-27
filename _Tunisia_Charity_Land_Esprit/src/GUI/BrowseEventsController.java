/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Evenement;
import Service.ServiceEvenement;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.IntStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author machd
 */
public class BrowseEventsController  implements Initializable  {

    @FXML
    private ImageView image1;
    @FXML
    private ImageView image2;
    @FXML
    private ImageView image3;
    @FXML
    private ImageView image4;
    @FXML
    private ImageView image5;
    @FXML
    private ImageView image6;
    @FXML
    private Button next;
     @FXML
    private Button previous;
    private final ServiceEvenement serv = new ServiceEvenement();
    private  ArrayList<Evenement> lisOfEvent = serv.read();

    private final int nbP = lisOfEvent.size() / 6 + fct(lisOfEvent.size() % 6);
    private int CurrP = 1;
    private int i;
    private int nbrOfimgInlastPage;
    int x;
    @FXML
    private Label date1;
    @FXML
    private Label date2;
    @FXML
    private Label date3;
    @FXML
    private Label date4;
    @FXML
    private Label date5;
    @FXML
    private Label date6;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Init images
        initImages();

    }

    @FXML
    private void goToNext(ActionEvent event) throws SQLException {
        System.out.println("\t\t\n");
        System.out.println("we are in page  : " + CurrP);
        System.out.println("nuber of image browsed  : " + i);
        System.out.println("nuber of elements in the last page :" + nbrOfimgInlastPage);
        loadNextPage();
        System.out.println("**************goToNext page called***************** ");
        System.out.println("\t\t\tn");
        System.out.println("we are in page  : " + CurrP);
        System.out.println("nuber of image browsed  : " + i);
        System.out.println("nuber of elements in the last page :" + nbrOfimgInlastPage);

    }

    @FXML
    private void goToPrevious(ActionEvent event) {
        if (CurrP >= 1) {
            System.out.println("\t\t\n");
            System.out.println("we are in page  : " + CurrP);
            System.out.println("nuber of image browsed  : " + i);
            System.out.println("nuber of elements in the last page :" + nbrOfimgInlastPage);
            loadPreviousPage();
            System.out.println("**************goToPrevious page called***************** ");
            System.out.println("we are in page  : " + CurrP);
            System.out.println("nuber of image browsed  : " + i);
            System.out.println("nuber of elements in the last page :" + nbrOfimgInlastPage);
        }

    }

    public void initImages() {   
        lisOfEvent = serv.read();
        if (lisOfEvent.size() > 0) {
            loadImage1(lisOfEvent.get(0).getImg_url());
            loadDate1(lisOfEvent.get(0).getDate());
            
        }

        if (lisOfEvent.size() > 1) {
            loadImage2(lisOfEvent.get(1).getImg_url());
            loadDate2(lisOfEvent.get(1).getDate());
        }

        if (lisOfEvent.size() > 2) {
            loadImage3(lisOfEvent.get(2).getImg_url());
            loadDate3(lisOfEvent.get(2).getDate());
        }

        if (lisOfEvent.size() > 3) {
            loadImage4(lisOfEvent.get(3).getImg_url());
             loadDate4(lisOfEvent.get(3).getDate());
        }

        if (lisOfEvent.size() > 4) {
            loadImage5(lisOfEvent.get(4).getImg_url());
            loadDate5(lisOfEvent.get(4).getDate());
        }

        if (lisOfEvent.size() > 5) {
            loadImage6(lisOfEvent.get(5).getImg_url());
            loadDate6(lisOfEvent.get(5).getDate());
        }

    }

    public void intImageToEmpty() {
        Image image = new Image("images/empty-image.jpg");
        image1.setImage(image);
        image2.setImage(image);
        image3.setImage(image);
        image4.setImage(image);
        image5.setImage(image);
        image6.setImage(image);
        
        date1.setText("");
        date2.setText("");
        date3.setText("");
        date4.setText("");
        date5.setText("");
        date6.setText("");
    }
 

    public void loadImage1(String url) {
        Image img1 = new Image(url);
        image1.setImage(img1);
        
    }
    public void loadDate1(Date date){
        date1.setText("Date :"+date.toString());
    }

    public void loadImage2(String url) {
        Image img = new Image(url);
        image2.setImage(img);
    }
    public void loadDate2(Date date){
        date2.setText("Date :"+date.toString());
    }

    public void loadImage3(String url) {
        Image img = new Image(url);
        image3.setImage(img);
    }
     public void loadDate3(Date date){
        date3.setText("Date :"+date.toString());
    }

    public void loadImage4(String url) {
        Image img = new Image(url);
        image4.setImage(img);
    }
    public void loadDate4(Date date){
        date4.setText("Date :"+date.toString());
    }
    public void loadImage5(String url) {
        Image img = new Image(url);
        image5.setImage(img);
    }
    public void loadDate5(Date date){
        date5.setText("Date :"+date.toString());
    }
    public void loadImage6(String url) {
        Image img = new Image(url);
        image6.setImage(img);
    }
     public void loadDate6(Date date){
        date6.setText("Date :"+date.toString());
    }

    public void loadNextPage() throws SQLException {
        ServiceEvenement serv = new ServiceEvenement();
        ArrayList<Evenement> lisOfEvent = serv.read();

        if (CurrP < nbP - 1) {
            i = 0;
            loadImage1(lisOfEvent.get(CurrP * 6 + i).getImg_url());
            loadDate1(lisOfEvent.get(CurrP * 6 + i).getDate());
            i++;
            //System.out.println("  i: " + i);
            loadImage2(lisOfEvent.get(CurrP * 6 + i).getImg_url());
            loadDate2(lisOfEvent.get(CurrP * 6 + i).getDate());
            i++;
            loadImage3(lisOfEvent.get(CurrP * 6 + i).getImg_url());
            loadDate3(lisOfEvent.get(CurrP * 6 + i).getDate());
            i++;
            loadImage4(lisOfEvent.get(CurrP * 6 + i).getImg_url());
            loadDate4(lisOfEvent.get(CurrP * 6 + i).getDate());
            i++;
            loadImage5(lisOfEvent.get(CurrP * 6 + i).getImg_url());
            loadDate5(lisOfEvent.get(CurrP * 6 + i).getDate());
            i++;
            loadImage6(lisOfEvent.get(CurrP * 6 + i).getImg_url());
            loadDate6(lisOfEvent.get(CurrP * 6 + i).getDate());
            i++;
            CurrP++;

        } else if (CurrP < nbP) {
            i = 0;
            intImageToEmpty();
            if (CurrP * 6 + i < lisOfEvent.size()) {
                loadImage1(lisOfEvent.get(CurrP * 6 + i).getImg_url());
                loadDate1(lisOfEvent.get(CurrP * 6 + i).getDate());
                i++;
                nbrOfimgInlastPage++;
            }
            if (CurrP * 6 + i < lisOfEvent.size()) {
                loadImage2(lisOfEvent.get(CurrP * 6 + i).getImg_url());
                loadDate2(lisOfEvent.get(CurrP * 6 + i).getDate());
                i++;
                nbrOfimgInlastPage++;
            }
            if (CurrP * 6 + i < lisOfEvent.size()) {
                loadImage3(lisOfEvent.get(CurrP * 6 + i).getImg_url());
                loadDate3(lisOfEvent.get(CurrP * 6 + i).getDate());
                i++;
                nbrOfimgInlastPage++;
            }
            if (CurrP * 6 + i < lisOfEvent.size()) {
                loadImage4(lisOfEvent.get(CurrP * 6 + i).getImg_url());
                loadDate4(lisOfEvent.get(CurrP * 6 + i).getDate());
                i++;
                nbrOfimgInlastPage++;
            }
            if (CurrP * 6 + i < lisOfEvent.size()) {
                loadImage5(lisOfEvent.get(CurrP * 6 + i).getImg_url());
                loadDate5(lisOfEvent.get(CurrP * 6 + i).getDate());
                i++;
                nbrOfimgInlastPage++;
            }
            if (CurrP * 6 + i < lisOfEvent.size()) {
                loadImage6(lisOfEvent.get(CurrP * 6 + i).getImg_url());
                loadDate6(lisOfEvent.get(CurrP * 6 + i).getDate());
                nbrOfimgInlastPage++;
                i++;
            }
            //CurrP++;

//            CurrP = 0;
//            i = 0;
        }
          
    }

    public void loadPreviousPage() {

//           System.out.println("##########");
//           System.out.println("index :"+i);
//           System.out.println("##########");
        lisOfEvent = serv.read();
        CurrP--;
        if (CurrP < nbP){
        i = 0;
        int x=CurrP * 6+i;
        loadImage1(lisOfEvent.get(x).getImg_url());
        loadDate1(lisOfEvent.get(CurrP * 6 + i).getDate());
        i++;
        x=CurrP * 6 + i;
        System.out.println("  i: " + i+"Curr: "+CurrP+"i in page: "+x);
        
        loadImage2(lisOfEvent.get(x).getImg_url());
        loadDate2(lisOfEvent.get(CurrP * 6 + i).getDate());
        i++;
        loadImage3(lisOfEvent.get(CurrP * 6 + i).getImg_url());
        loadDate3(lisOfEvent.get(CurrP * 6 + i).getDate());
        i++;
        loadImage4(lisOfEvent.get(CurrP * 6 + i).getImg_url());
        loadDate4(lisOfEvent.get(CurrP * 6 + i).getDate());
        i++;
        loadImage5(lisOfEvent.get(CurrP * 6 + i).getImg_url());
        loadDate5(lisOfEvent.get(CurrP * 6 + i).getDate());
        
        i++;
        loadImage6(lisOfEvent.get(CurrP * 6 + i).getImg_url());
        loadDate6(lisOfEvent.get(CurrP * 6 + i).getDate());
        i++;}
      
//           IntStream.range(0, 1).forEach(
//                i -> next.fire()
//        );  
        
       

//            CurrP = 0;
//            i = 0;
    }



public int fct(int i) {
        if (i != 0) {
            return 1;
        } else {
            return i;
        }
    }

}
