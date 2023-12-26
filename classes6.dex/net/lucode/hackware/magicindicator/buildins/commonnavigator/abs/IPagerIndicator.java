package net.lucode.hackware.magicindicator.buildins.commonnavigator.abs;

import java.util.List;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.model.PositionData;

public interface IPagerIndicator {
    void onPageScrollStateChanged(int i);

    void onPageScrolled(int i, float f, int i2);

    void onPageSelected(int i);

    void onPositionDataProvide(List<PositionData> list);
}
