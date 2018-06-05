import java.util.ArrayList;

public class Path {
	private ArrayList<Location> gridPath;
	private ArrayList<Location> pixelPath;

	public Path(ArrayList<Location> path) {
		Location loc1, loc2;
		gridPath = new ArrayList<Location>();
		gridPath.add(path.get(0));
		for (int i = 0; i < path.size() - 1; i++) {
			loc1 = path.get(i);
			loc2 = path.get(i + 1);
			if (loc1.getY() == loc2.getY()) {
				if (loc1.getX() > loc2.getX()) {
					for (int j = loc1.getX() - 1; j >= loc2.getX(); j--)
						gridPath.add(new Location(j, loc1.getY()));
				} else {
					for (int j = loc1.getX() + 1; j <= loc2.getX(); j++)
						gridPath.add(new Location(j, loc1.getY()));
				}
			} else {
				if (loc1.getY() > loc2.getY()) {
					for (int j = loc1.getY() - 1; j >= loc2.getY(); j--)
						gridPath.add(new Location(loc1.getX(), j));
				} else {
					for (int j = loc1.getY() + 1; j <= loc2.getY(); j++)
						gridPath.add(new Location(loc1.getX(), j));
				}
			}

		}
		pixelPath = new ArrayList<Location>();
		for (Location l : path) {
			// Use actual JButton size to get translation correct
			pixelPath.add(new Location((l.getX() * Constants.PIXELS_PER_SQUARE_HORIZ), (l.getY() * Constants.PIXELS_PER_SQUARE_VERT)));
				//	new Location((l.getX() * Constants.PIXELS_PER_SQUARE), (l.getY() * Constants.PIXELS_PER_SQUARE)));
		}
		System.out.println("Pixel path = " + pixelPath);
	}

	public Location getGrid(int stage) {
		return gridPath.get(stage);
	}

	public ArrayList<Location> getFullGridPath() {
		return gridPath;
	}

	public Location getPixel(int stage) {
		return pixelPath.get(stage);
	}

	public ArrayList<Location> getFullPixelPath() {
		return pixelPath;
	}

	public int length() {
		return gridPath.size();
	}
}
