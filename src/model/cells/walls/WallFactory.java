package model.cells.walls;

public class WallFactory {

    public Wall getWall (char selector) {

        switch (selector) {

            case 'l':
                return new GrassWall();

            case 'w':
                return new StoneWall();

        }

        return null;
    }

}
