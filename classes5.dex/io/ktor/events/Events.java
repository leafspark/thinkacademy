package io.ktor.events;

import io.ktor.util.collections.CopyOnWriteHashMap;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J'\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u00052\u0006\u0010\f\u001a\u0002H\n¢\u0006\u0002\u0010\rJ8\u0010\u000e\u001a\u00020\u000f\"\u0004\b\u0000\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u00052\u001c\u0010\u0010\u001a\u0018\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\t0\u0011j\b\u0012\u0004\u0012\u0002H\n`\u0012J8\u0010\u0013\u001a\u00020\t\"\u0004\b\u0000\u0010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\u00052\u001c\u0010\u0010\u001a\u0018\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\t0\u0011j\b\u0012\u0004\u0012\u0002H\n`\u0012R$\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002¨\u0006\u0015"}, d2 = {"Lio/ktor/events/Events;", "", "()V", "handlers", "Lio/ktor/util/collections/CopyOnWriteHashMap;", "Lio/ktor/events/EventDefinition;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "getHandlers$annotations", "raise", "", "T", "definition", "value", "(Lio/ktor/events/EventDefinition;Ljava/lang/Object;)V", "subscribe", "Lkotlinx/coroutines/DisposableHandle;", "handler", "Lkotlin/Function1;", "Lio/ktor/events/EventHandler;", "unsubscribe", "HandlerRegistration", "ktor-events"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Events.kt */
public final class Events {
    private final CopyOnWriteHashMap<EventDefinition<?>, LockFreeLinkedListHead> handlers = new CopyOnWriteHashMap<>();

    private static /* synthetic */ void getHandlers$annotations() {
    }

    public final <T> DisposableHandle subscribe(EventDefinition<T> eventDefinition, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(eventDefinition, "definition");
        Intrinsics.checkNotNullParameter(function1, "handler");
        DisposableHandle handlerRegistration = new HandlerRegistration(function1);
        this.handlers.computeIfAbsent(eventDefinition, Events$subscribe$1.INSTANCE).addLast((LockFreeLinkedListNode) handlerRegistration);
        return handlerRegistration;
    }

    public final <T> void unsubscribe(EventDefinition<T> eventDefinition, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(eventDefinition, "definition");
        Intrinsics.checkNotNullParameter(function1, "handler");
        LockFreeLinkedListHead lockFreeLinkedListHead = this.handlers.get(eventDefinition);
        if (lockFreeLinkedListHead != null) {
            for (HandlerRegistration handlerRegistration = (LockFreeLinkedListNode) lockFreeLinkedListHead.getNext(); !Intrinsics.areEqual(handlerRegistration, lockFreeLinkedListHead); handlerRegistration = handlerRegistration.getNextNode()) {
                if (handlerRegistration instanceof HandlerRegistration) {
                    HandlerRegistration handlerRegistration2 = handlerRegistration;
                    if (Intrinsics.areEqual(handlerRegistration2.getHandler(), function1)) {
                        handlerRegistration2.remove();
                    }
                }
            }
        }
    }

    public final <T> void raise(EventDefinition<T> eventDefinition, T t) {
        Unit unit;
        Intrinsics.checkNotNullParameter(eventDefinition, "definition");
        LockFreeLinkedListHead lockFreeLinkedListHead = this.handlers.get(eventDefinition);
        Throwable th = null;
        if (lockFreeLinkedListHead != null) {
            Throwable th2 = null;
            for (HandlerRegistration handlerRegistration = (LockFreeLinkedListNode) lockFreeLinkedListHead.getNext(); !Intrinsics.areEqual(handlerRegistration, lockFreeLinkedListHead); handlerRegistration = handlerRegistration.getNextNode()) {
                if (handlerRegistration instanceof HandlerRegistration) {
                    try {
                        ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(handlerRegistration.getHandler(), 1)).invoke(t);
                    } catch (Throwable th3) {
                        Throwable th4 = th2;
                        if (th4 != null) {
                            ExceptionsKt.addSuppressed(th4, th3);
                            unit = Unit.INSTANCE;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            th2 = th3;
                        }
                    }
                }
            }
            th = th2;
        }
        if (th != null) {
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0018\u0010\u0003\u001a\u0014\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00050\u0004j\u0006\u0012\u0002\b\u0003`\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u0005H\u0016R#\u0010\u0003\u001a\u0014\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00050\u0004j\u0006\u0012\u0002\b\u0003`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lio/ktor/events/Events$HandlerRegistration;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/DisposableHandle;", "handler", "Lkotlin/Function1;", "", "Lio/ktor/events/EventHandler;", "(Lkotlin/jvm/functions/Function1;)V", "getHandler", "()Lkotlin/jvm/functions/Function1;", "dispose", "ktor-events"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Events.kt */
    private static final class HandlerRegistration extends LockFreeLinkedListNode implements DisposableHandle {
        private final Function1<?, Unit> handler;

        public HandlerRegistration(Function1<?, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "handler");
            this.handler = function1;
        }

        public final Function1<?, Unit> getHandler() {
            return this.handler;
        }

        public void dispose() {
            remove();
        }
    }
}
