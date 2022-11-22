public class Tool {
    private String toolName;
    private int toolCost;
    private double toolExp;

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public int getToolCost() {
        return toolCost;
    }

    public void setToolCost(int toolCost) {
        this.toolCost = toolCost;
    }

    public double getToolExp() {
        return toolExp;
    }

    public void setToolExp(double toolExp) {
        this.toolExp = toolExp;
    }

    public Tool(String toolName, int toolCost, double toolExp){
        /** Creates a Tool object by supplying the name of the tool,
         * cost of usage and the experience gained when used.
         *
         * @param toolName	    the name of the tool
         * @param toolCost	    cost of the tool when used
         * @param toolExp	    experience gained when used
         */
        this.toolName = toolName;
        this.toolCost = toolCost;
        this.toolExp = toolExp;
    }

    // WILL TRY TO IMPLEMENT TOOL ACTIONS IN FARMER CLASS TODO: [UML] UPDATE TOOL CLASSES
}
