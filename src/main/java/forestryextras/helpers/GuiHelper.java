package forestryextras.helpers;

public class GuiHelper {
	public static boolean isMouseBetween(int mouseX, int mouseY, int x, int y, int width, int height) {
		int xSize = x + width;
		int ySize = y + height;
		
		return (mouseX > x && mouseX < xSize && mouseY > y && mouseY < ySize);
	}
}