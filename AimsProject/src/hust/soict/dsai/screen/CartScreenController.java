package hust.soict.dsai.screen;

import hust.soict.dsai.cart.Cart;
import hust.soict.dsai.exception.PlayerException;
import hust.soict.dsai.media.Disc;
import hust.soict.dsai.media.Media;
import hust.soict.dsai.media.Playable;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


public class CartScreenController {
    private Cart cart;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnPlaceOrder;
    @FXML
    private TextField tfFilter;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private Label totalCostLabel;

    // Chứa danh sách các sản phẩm lọc theo điều kiện
    private FilteredList<Media> filteredList;

    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
        this.filteredList = new FilteredList<Media>(cart.getItemsOrdered());
    }

    // Khởi tạo các event
    @FXML
    private void initialize() {
        // Fill dữ liệu tương ứng với các cột trong bảng
        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("category")
        );

        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("title")
        );

        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("cost")
        );

        //Đổ dữ liệu ra bảng để hiển thị
        tblMedia.setItems(filteredList);

        // Mặc định ban đầu là ẩn nút Play và Remove đi
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        totalCostLabel.setText(String.valueOf(cart.totalCost()));

        // Ẩn hiẹn nút play, remove khi ớ 1 dòng được select
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                        if(newValue != null) {
                            // Nếu có item được select thì hiện chúng lên
                            updateButtonBar(newValue);
                        } else {
                            //Không có item nào được select thì ẩn cả 2 nút đi
                            btnPlay.setVisible(false);
                            btnRemove.setVisible(false);
                        }
                    }
                }

        );

        // Bắt sự kiện ô input keyword thay đổi, nếu có thay đổi thì tiến hành lọc dữ liệu
        tfFilter.textProperty().addListener(
                new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                        showFilterMedia(newValue);
                    }
                }
        );

        // Lắng nghe sự thay đổi của danh sách sản phẩm trong giỏ hàng và tính lại tiền
        cart.getItemsOrdered().addListener((ListChangeListener<Media>) change -> {
            while (change.next()) {
                //System.out.println(cart.totalCost());
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        // Update tiền của đơn hàng
                        totalCostLabel.setText(String.valueOf(cart.totalCost()) + " $");
                        System.out.println("Update total cost");
                    }
                });

            }
        });




    }

    /**
     * Handle event khi bấm vào nút xóa trong giỏ hàng
     * @param event
     */
    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

    /**
     * Handle khi nhấn button Place Order
     * @param event
     */
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        cart.placeOrder();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");
        alert.setHeaderText("Đặt hàng thành công");
        alert.show();
    }

    /**
     * Handle khi nhấn vào button Play
     * @param event
     */
    @FXML
    void btnPlayPressed(ActionEvent event) {
        // Lấy media hiện tại
        Playable media = (Playable)tblMedia.getSelectionModel().getSelectedItem();
        // Lấy title của media hiện tại
        String mediaTitle = tblMedia.getSelectionModel().getSelectedItem().getTitle();
        try {
            // Play
            media.play();
            // Hiển thị thông báo
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Trình phát nhạc");
            Disc disc = (Disc)media;
            alert.setHeaderText("Bạn đang nghe bản nhạc " + mediaTitle + " của ca sỹ: " + disc.getDirector());
            alert.show();
        } catch (PlayerException e) {
            // Bắt lỗi nếu có
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Thông báo");
            alert.setHeaderText(e.getLocalizedMessage());
            alert.show();
        }

    }

    /**
     * Hàm hỗ trợ điều khiển việc ẩn hiện của button Play và Remove
     * @param media
     */
    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if(media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }

    /**
     * Handle việc lọc dữ liệu
     * @param filter
     */
    void showFilterMedia(String filter) {
        filteredList.setPredicate(item -> {
            if(filter.isEmpty()) {
                return true;
            }
            try {
                // Nếu lọc theo ID
                if(radioBtnFilterId.isSelected()) {
                    return String.valueOf(item.getId()).equals(filter);
                } else if(radioBtnFilterTitle.isSelected()) {
                    // Nếu lọc theo title
                    return item.getTitle().contains(filter);
                }
            } catch(Exception e) {
                e.printStackTrace();
            }

            return true;

        });

    }


}