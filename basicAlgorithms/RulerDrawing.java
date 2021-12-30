public class RulerDrawing {
    private  void  drawRuler(int inches , int majorLength)
    {
        drawLine(majorLength, 0);
        for(int i=1; i<=inches; i++)
        {
            drawInterval(majorLength - 1);
            drawLine(majorLength, i);
        }
    }
    private void drawInterval(int rulerLength)
    {
        if(rulerLength >= 1)
        {
            drawInterval(rulerLength - 1);
            drawLine(rulerLength);
            drawInterval(rulerLength - 1);
        }
    }
    public void drawLine(int tickLength , int tickLabel)
    {
        for(int j =0; j<tickLength; j++)
            System.out.print('-');
        if(tickLabel >= 0)
        {
            System.out.print(" " + tickLabel);
        }
        System.out.print("\n");
    }
    public void drawLine(int tickLabel)
    {
        drawLine(tickLabel , -1);
    }
    public static void main(String[] args) {
        RulerDrawing ruler = new RulerDrawing();
        ruler.drawRuler(2, 4);
    }
}
