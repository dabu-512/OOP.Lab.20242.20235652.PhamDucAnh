package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;

public class MediaStore extends JPanel {
	private static final long serialVersionUID = 1L;
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addToCartButton = new JButton("Add to cart");
        container.add(addToCartButton);

        // Nếu media là Playable thì thêm nút Play
        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(e -> {
                // Tạo một JDialog mới
                JDialog playDialog = new JDialog();
                playDialog.setTitle("Playing " + media.getTitle());
                playDialog.setSize(300, 200);
                playDialog.setLocationRelativeTo(null); // Center the dialog

                // Thêm một JLabel để hiển thị thông tin hoặc điều khiển phát
                JLabel playingLabel = new JLabel("Now playing: " + media.getTitle());
                playingLabel.setHorizontalAlignment(SwingConstants.CENTER);
                playDialog.add(playingLabel, BorderLayout.CENTER);

                // Thêm nút để đóng dialog
                JButton closeButton = new JButton("Close");
                closeButton.addActionListener(event -> playDialog.dispose());
                playDialog.add(closeButton, BorderLayout.SOUTH);

                // Hiển thị dialog
                playDialog.setVisible(true);

                // Gọi phương thức play nếu cần
                ((Playable) media).play();
            });
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalStrut(10));
        this.add(container);
        this.add(Box.createVerticalGlue());

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}