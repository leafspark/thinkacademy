package com.kaisengao.likeview.like;

import java.util.List;

public interface IAnimationLayout {
    void addFavor();

    void addLikeImage(int i);

    void addLikeImages(List<Integer> list);

    void addLikeImages(Integer... numArr);
}
