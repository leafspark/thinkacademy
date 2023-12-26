package io.reactivex.internal.subscriptions;

import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Subscription;

public final class ArrayCompositeSubscription extends AtomicReferenceArray<Subscription> implements Disposable {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeSubscription(int i) {
        super(i);
    }

    public boolean setResource(int i, Subscription subscription) {
        SubscriptionHelper subscriptionHelper;
        do {
            subscriptionHelper = (Subscription) get(i);
            if (subscriptionHelper == SubscriptionHelper.CANCELLED) {
                if (subscription == null) {
                    return false;
                }
                subscription.cancel();
                return false;
            }
        } while (!compareAndSet(i, subscriptionHelper, subscription));
        if (subscriptionHelper == null) {
            return true;
        }
        subscriptionHelper.cancel();
        return true;
    }

    public Subscription replaceResource(int i, Subscription subscription) {
        SubscriptionHelper subscriptionHelper;
        do {
            subscriptionHelper = (Subscription) get(i);
            if (subscriptionHelper == SubscriptionHelper.CANCELLED) {
                if (subscription == null) {
                    return null;
                }
                subscription.cancel();
                return null;
            }
        } while (!compareAndSet(i, subscriptionHelper, subscription));
        return subscriptionHelper;
    }

    public void dispose() {
        SubscriptionHelper subscriptionHelper;
        if (get(0) != SubscriptionHelper.CANCELLED) {
            int length = length();
            for (int i = 0; i < length; i++) {
                if (!(((Subscription) get(i)) == SubscriptionHelper.CANCELLED || (subscriptionHelper = (Subscription) getAndSet(i, SubscriptionHelper.CANCELLED)) == SubscriptionHelper.CANCELLED || subscriptionHelper == null)) {
                    subscriptionHelper.cancel();
                }
            }
        }
    }

    public boolean isDisposed() {
        return get(0) == SubscriptionHelper.CANCELLED;
    }
}
