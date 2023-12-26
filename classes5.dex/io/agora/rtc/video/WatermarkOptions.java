package io.agora.rtc.video;

public class WatermarkOptions {
    public Rectangle positionInLandscapeMode = new Rectangle();
    public Rectangle positionInPortraitMode = new Rectangle();
    public boolean visibleInPreview = true;

    public static class Rectangle {
        public int height;
        public int width;
        public int x;
        public int y;

        public Rectangle() {
            this.x = 0;
            this.y = 0;
            this.width = 0;
            this.height = 0;
            this.x = 0;
            this.y = 0;
            this.width = 0;
            this.height = 0;
        }

        public Rectangle(int i, int i2, int i3, int i4) {
            this.x = 0;
            this.y = 0;
            this.width = 0;
            this.height = 0;
            this.x = i;
            this.y = i2;
            this.width = i3;
            this.height = i4;
        }
    }
}
