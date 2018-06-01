import javax.swing.ImageIcon;

public class ImageLoader {

	private ImageIcon BasicTower;
	private ImageIcon FireTower;
	private ImageIcon IceTower;
	private ImageIcon SniperTower;
	private ImageIcon UberTower;
	private ImageIcon Enemy;

	public ImageLoader() {
		ClassLoader cldr = this.getClass().getClassLoader();
		// BasicTower = new ImageIcon(
		// cldr.getResource("https://gfycat.com/gifs/search/tower+defense"));
		// FireTower = new ImageIcon(
		// cldr.getResource("https://gfycat.com/gifs/detail/DistantJoyfulCrane"));
		// IceTower = new ImageIcon(
		// cldr.getResource("https://mobilegamegraphics.com/product/isometric-tower-defense-assets/isometric-ice-frozen-tower-defense/"));
		// SniperTower = new ImageIcon(
		// cldr.getResource("https://www.pinterest.com.au/pin/302937512416993831/"));
		// UberTower = new ImageIcon(
		// cldr.getResource("https://graphicriver.net/item/isometric-tower-defense-game-kit-3-of-3-w-character-sprites-more/16901853"));
		//Enemy = new ImageIcon(
				//cldr.getResource("Resources\\Bug.gif"));
	}

	public ImageIcon getBasic() {
		return BasicTower;
	}

	public ImageIcon getFire() {
		return FireTower;
	}

	public ImageIcon getIce() {
		return IceTower;
	}

	public ImageIcon getSniper() {
		return SniperTower;
	}

	public ImageIcon getUber() {
		return UberTower;
	}

	public ImageIcon getEnemy() {
		return Enemy;
	}

}