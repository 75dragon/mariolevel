package level;

import java.util.Random;

public class WorldGeneration {
	Tile[][] theWorld;
	int xDim;
	int yDim;
	Random rand;

	/**
	 * the params are the x/y dimention. we will store our array like
	 * Tile[x][y]. So make sure you are accessing it like that!
	 * 
	 * @param x
	 *            - minimum of a hundred please
	 * @param y
	 *            - minimum of ten please
	 */
	public WorldGeneration(int x, int y) {
		rand = new Random();
		xDim = x;
		yDim = y;
		System.out.println(xDim);
		System.out.println(yDim);
		theWorld = new Tile[x][y];
		basics();
		addPits(7, 5);
		addRamdomBlocks((x + y) * 1 / 3);
		addPlatforms(7, 9);
		addHills(5, 5);
		printWorld();
	}

	/**
	 * just build a very simple level, its all open, passable tiles until you
	 * reach the floor - on layer of tiles that represents the ground
	 */
	public void basics() {
		for (int yy = 0; yy < yDim - 1; yy++) {
			for (int xx = 0; xx < xDim; xx++) {
				theWorld[xx][yy] = new Tile(xx, yy, 30, true);
			}
		}
		for (int xx = 0; xx < xDim; xx++) {
			theWorld[xx][yDim - 1] = new Tile(xx, yDim - 1, 30, false);
		}
	}

	/**
	 * note: the first and last 15 tiles must not be pits: its the end /
	 * beginning of the level!
	 * 
	 * @param x
	 *            how many pits there should be
	 * @param width
	 *            how wide the pits are to jump over
	 */
	public void addPits(int i, int width) {

		int[] holdPits = new int[i];
		boolean check;
		int hold;
		int done = 0;
		while (done < i) {
			check = true;
			hold = rand.nextInt(xDim - 15) + 10;
			for (int j = 0; j < done; j++) {
				if (Math.abs(hold - holdPits[j]) < width) {
					check = false;
				}
			}
			if (check) {
				holdPits[done] = hold;
				done++;
			}
		}

		for (int j = 0; j < i; j++) {
			for (int xx = holdPits[j]; xx - holdPits[j] < width; xx++) {
				theWorld[xx][yDim - 1] = new Tile(xx, yDim - 1, 30, true);
			}
		}
	}

	/**
	 * just create some completely random block in the place why not?
	 * 
	 * @param amount
	 *            of blocks to place
	 */
	public void addRamdomBlocks(int amount) {
		int holdx;
		int holdy;
		for (int i = 0; i < amount; i++) {
			holdx = rand.nextInt(xDim - 15) + 10;
			holdy = rand.nextInt(yDim);
			theWorld[holdx][holdy] = new Tile(holdx, holdy, 30, false);
		}
	}

	public void printWorld() {
		for (int yy = 0; yy < yDim; yy++) {
			for (int xx = 0; xx < xDim; xx++) {
				if (theWorld[xx][yy].passable) {
					System.out.print(" ");
				} else {
					System.out.print("#");
				}
			}
			System.out.println();
		}
	}

	public Tile[][] getWorld() {
		return theWorld;
	}

	public void addPlatforms(int platform_width, int amount) {
		int holdx;
		int holdy;
		for (int i = 0; i < amount; i++) {
			holdx = rand.nextInt(xDim - 15) + 10;
			holdy = rand.nextInt(yDim);
			for (int a = 0; a < platform_width; a++) {
				Tile mytile = new Tile((holdx + a), holdy, 30, false);
				theWorld[holdx + a][holdy] = mytile;
			}
		}
	}
	
	public void addHills(int platform_width, int amount) {
		int holdx;
		for (int i = 0; i < amount; i++) {
			holdx = rand.nextInt(xDim - 15) + 10;
			for (int a = 0; a < platform_width; a++) {
				Tile mytile = new Tile((holdx + a), yDim - 2 , 30, false);
				theWorld[holdx + a][yDim - 2] = mytile;
			}
		}
	}
}
