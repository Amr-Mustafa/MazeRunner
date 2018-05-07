package model.maze.generator;

public class SubCell {

    /* Content of the subcell. */
    private String content;

    public SubCell (String content) {
        this.content = content;
    }

    /**
     * Getter for the content field of the sub-cell.
     * @return char
     */
    public String getContent () {
        return content;
    }

    /**
     * Setter for the content field of the sub-cell.
     * @param content
     */
    public void setContent (String content) {
        this.content = content;
    }

}