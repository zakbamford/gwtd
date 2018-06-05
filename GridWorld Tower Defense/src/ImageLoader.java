import javax.swing.*;
import java.net.URL;

public class ImageLoader {

	private ImageIcon BasicTower;
	private ImageIcon FireTower;
	private ImageIcon IceTower;
	private ImageIcon SniperTower;
	private ImageIcon UberTower;
	private ImageIcon redBug;
	private ImageIcon blueBug;
	private ImageIcon greenBug;
	private ImageIcon yellowBug;
	private ImageIcon pinkBug;
	private ImageIcon purpleBug;
	private ImageIcon orangeBug;

	public ImageLoader() {
		ClassLoader cldr = this.getClass().getClassLoader();
		BasicTower = new ImageIcon(
				cldr.getResource("resources/Towers/BasicTower.png"));
		FireTower = new ImageIcon(
				cldr.getResource("resources/Towers/FireTower.png"));
		IceTower = new ImageIcon(
				cldr.getResource("resources/Towers/IceTower.png"));
		SniperTower = new ImageIcon(
				cldr.getResource("resources/Towers/SniperTower.png"));
		UberTower = new ImageIcon(
				cldr.getResource("resources/Towers/UberTower.png"));
		redBug = new ImageIcon(
				cldr.getResource("resources/Enemies/RedBug.png"));
		blueBug = new ImageIcon(
				cldr.getResource("resources/Enemies/BlueBug.png"));
		greenBug = new ImageIcon(
				cldr.getResource("resources/Enemies/GreenBug.png"));
		yellowBug = new ImageIcon(
				cldr.getResource("resources/Enemies/YellowBug.png"));
		pinkBug = new ImageIcon(
				cldr.getResource("resources/Enemies/PinkBug.png"));
		purpleBug = new ImageIcon(
				cldr.getResource("resources/Enemies/PurpleBug.png"));
		orangeBug = new ImageIcon(
				cldr.getResource("resources/Enemies/OrangeBug.png"));
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
