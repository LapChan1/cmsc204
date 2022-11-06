module a4 {
	requires javafx.graphics;
	requires javafx.controls;
	requires java.desktop;
	requires junit;

	opens a4 to javafx.graphics, javafx.fxml;
}