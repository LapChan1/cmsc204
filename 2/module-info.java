module a2 {
	requires junit;
	requires javafx.graphics;
	requires javafx.controls;
	requires java.desktop;

	opens a2 to javafx.graphics, javafx.fxml;
}