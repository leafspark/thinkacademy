package com.xueersi.lib.graffiti.protobean;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import com.wushuangtech.wstechapi.constants.OmniModuleConstants;
import com.yalantis.ucrop.view.CropImageView;
import io.agora.rtc.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class WXWBTCPPacketDataOuterClass {

    public interface AnyOrBuilder extends MessageLiteOrBuilder {
        String getTypeUrl();

        ByteString getTypeUrlBytes();

        ByteString getValue();
    }

    public interface WXWBCanvasInfoOrBuilder extends MessageLiteOrBuilder {
        int getCanvasId();

        int getFillColor();

        float getHeight();

        float getLineWidth();

        int getStrokeColor();

        float getWidth();

        float getX();

        float getY();
    }

    public interface WXWBChooseConfigOrBuilder extends MessageLiteOrBuilder {
        float getSelectEndX();

        float getSelectEndY();

        String getSelectLineColor();

        ByteString getSelectLineColorBytes();

        int getSelectLineType();

        int getSelectLineWidth();

        int getSelectShape(int i);

        int getSelectShapeCount();

        List<Integer> getSelectShapeList();

        float getSelectStartX();

        float getSelectStartY();
    }

    public interface WXWBChooseShapeOffsetOrBuilder extends MessageLiteOrBuilder {
        float getEndOffsetX();

        float getEndOffsetY();

        float getStartOffsetX();

        float getStartOffsetY();
    }

    public interface WXWBCompassesConfigOrBuilder extends MessageLiteOrBuilder {
        boolean getEnable();

        float getLeft();

        float getRadius();

        float getRotate();

        float getTop();
    }

    public interface WXWBOffsetOrBuilder extends MessageLiteOrBuilder {
        float getOffsetX();

        float getOffsetY();
    }

    public interface WXWBPageConfigOrBuilder extends MessageLiteOrBuilder {
        String getCurrentPage();

        ByteString getCurrentPageBytes();

        String getPageList(int i);

        ByteString getPageListBytes(int i);

        int getPageListCount();

        List<String> getPageListList();
    }

    public interface WXWBPointOrBuilder extends MessageLiteOrBuilder {
        WXWBPointAction getAction();

        int getActionValue();

        String getErase();

        ByteString getEraseBytes();

        float getLineWidth();

        float getX();

        float getY();
    }

    public interface WXWBRefConfigOrBuilder extends MessageLiteOrBuilder {
        int getColor();

        int getDefaultHeight();

        int getDefaultWidth();

        String getFontFamily();

        ByteString getFontFamilyBytes();

        int getFontSize();

        String getImgUrl();

        ByteString getImgUrlBytes();

        int getLineHeight();

        String getRefId();

        ByteString getRefIdBytes();

        String getText();

        int getTextAlign();

        ByteString getTextBytes();
    }

    public interface WXWBRevokeAndRecoverConfigOrBuilder extends MessageLiteOrBuilder {
        String getActionList(int i);

        ByteString getActionListBytes(int i);

        int getActionListCount();

        List<String> getActionListList();

        int getHistoryIndex();

        int getIsReverse();
    }

    public interface WXWBRulerConfigOrBuilder extends MessageLiteOrBuilder {
        boolean getEnable();

        float getLeft();

        float getLength();

        float getRotate();

        float getTop();
    }

    public interface WXWBSelectAreaConfigOrBuilder extends MessageLiteOrBuilder {
        boolean containsLayerLocs(long j);

        boolean containsLineOffsets(long j);

        WXWBOffset getLassoOffset();

        @Deprecated
        Map<Long, WXWBChooseShapeOffset> getLayerLocs();

        int getLayerLocsCount();

        Map<Long, WXWBChooseShapeOffset> getLayerLocsMap();

        WXWBChooseShapeOffset getLayerLocsOrDefault(long j, WXWBChooseShapeOffset wXWBChooseShapeOffset);

        WXWBChooseShapeOffset getLayerLocsOrThrow(long j);

        long getLineIndexs(int i);

        int getLineIndexsCount();

        List<Long> getLineIndexsList();

        @Deprecated
        Map<Long, WXWBOffset> getLineOffsets();

        int getLineOffsetsCount();

        Map<Long, WXWBOffset> getLineOffsetsMap();

        WXWBOffset getLineOffsetsOrDefault(long j, WXWBOffset wXWBOffset);

        WXWBOffset getLineOffsetsOrThrow(long j);

        long getShapeIndexs(int i);

        int getShapeIndexsCount();

        List<Long> getShapeIndexsList();

        boolean hasLassoOffset();
    }

    public interface WXWBTCPPacketDataOrBuilder extends MessageLiteOrBuilder {
        int getBusinessType();

        WXWBCanvasInfo getCanvasInfo();

        WXWBChooseConfig getChooseConfig();

        WXWBCompassesConfig getCompassesConfig();

        String getCourseId();

        ByteString getCourseIdBytes();

        WXWBPoint getCursorPosition();

        long getDataCreateTimestamp();

        int getFillColor();

        int getHeight();

        long getLineIndex();

        WXWBLineType getLineType();

        int getLineTypeValue();

        float getLineWidth();

        long getMsgId();

        Any getMyBusiness();

        WXWBPageConfig getPageConfig();

        String getPageId();

        ByteString getPageIdBytes();

        WXWBPoint getPointList(int i);

        int getPointListCount();

        List<WXWBPoint> getPointListList();

        WXTPointType getPointType();

        int getPointTypeValue();

        WXWBRefConfig getRefConfig();

        WXWBRevokeAndRecoverConfig getRevokeAndRecoverConfig();

        float getRotation();

        WXWBRulerConfig getRulerConfig();

        WXWBSelectAreaConfig getSelectConfig();

        int getStrokeColor();

        WXWBMessageType getType();

        int getTypeValue();

        String getUid();

        ByteString getUidBytes();

        WXWBUserInfo getUserInfo();

        int getWidth();

        boolean hasCanvasInfo();

        boolean hasChooseConfig();

        boolean hasCompassesConfig();

        boolean hasCursorPosition();

        boolean hasMyBusiness();

        boolean hasPageConfig();

        boolean hasRefConfig();

        boolean hasRevokeAndRecoverConfig();

        boolean hasRulerConfig();

        boolean hasSelectConfig();

        boolean hasUserInfo();
    }

    public interface WXWBUserInfoOrBuilder extends MessageLiteOrBuilder {
        String getUname();

        ByteString getUnameBytes();
    }

    public static void registerAllExtensions(ExtensionRegistryLite extensionRegistryLite) {
    }

    private WXWBTCPPacketDataOuterClass() {
    }

    public enum WXWBMessageType implements Internal.EnumLite {
        WXWBMessageTypeRecover(0),
        WXWBMessageTypeCancel(1),
        WXWBMessageTypeUpdateShape(2),
        WXWBMessageTypeDraw(3),
        WXWBMessageTypeDeleteShape(4),
        WXWBMessageTypeClearAll(5),
        WXWBMessageTypeScroll(6),
        WXWBMessageTypeGeometry(7),
        WXWBMessageTypeChoose(9),
        WXWBMessageTypePointer(10),
        WXWBMessageTypeRuler(11),
        WXWBMessageTypeCompass(12),
        WXWBMessageTypeTimer(13),
        WXWBMessageTypeUpdateMiniBoard(14),
        WXWBMessageTypeDeleteMiniBoard(16),
        WXWBMessageTypeUpdateCustomView(17),
        WXWBMessageTypeBatchAction(18),
        WXWBMessageTypeTextBox(19),
        WXWBMessageTypeSignalCourseware(20),
        WXWBMessageTypeCustomBusiness(1000),
        UNRECOGNIZED(-1);
        
        public static final int WXWBMessageTypeBatchAction_VALUE = 18;
        public static final int WXWBMessageTypeCancel_VALUE = 1;
        public static final int WXWBMessageTypeChoose_VALUE = 9;
        public static final int WXWBMessageTypeClearAll_VALUE = 5;
        public static final int WXWBMessageTypeCompass_VALUE = 12;
        public static final int WXWBMessageTypeCustomBusiness_VALUE = 1000;
        public static final int WXWBMessageTypeDeleteMiniBoard_VALUE = 16;
        public static final int WXWBMessageTypeDeleteShape_VALUE = 4;
        public static final int WXWBMessageTypeDraw_VALUE = 3;
        public static final int WXWBMessageTypeGeometry_VALUE = 7;
        public static final int WXWBMessageTypePointer_VALUE = 10;
        public static final int WXWBMessageTypeRecover_VALUE = 0;
        public static final int WXWBMessageTypeRuler_VALUE = 11;
        public static final int WXWBMessageTypeScroll_VALUE = 6;
        public static final int WXWBMessageTypeSignalCourseware_VALUE = 20;
        public static final int WXWBMessageTypeTextBox_VALUE = 19;
        public static final int WXWBMessageTypeTimer_VALUE = 13;
        public static final int WXWBMessageTypeUpdateCustomView_VALUE = 17;
        public static final int WXWBMessageTypeUpdateMiniBoard_VALUE = 14;
        public static final int WXWBMessageTypeUpdateShape_VALUE = 2;
        private static final Internal.EnumLiteMap<WXWBMessageType> internalValueMap = null;
        private final int value;

        static {
            internalValueMap = new Internal.EnumLiteMap<WXWBMessageType>() {
                public WXWBMessageType findValueByNumber(int i) {
                    return WXWBMessageType.forNumber(i);
                }
            };
        }

        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static WXWBMessageType valueOf(int i) {
            return forNumber(i);
        }

        public static WXWBMessageType forNumber(int i) {
            if (i == 1000) {
                return WXWBMessageTypeCustomBusiness;
            }
            switch (i) {
                case 0:
                    return WXWBMessageTypeRecover;
                case 1:
                    return WXWBMessageTypeCancel;
                case 2:
                    return WXWBMessageTypeUpdateShape;
                case 3:
                    return WXWBMessageTypeDraw;
                case 4:
                    return WXWBMessageTypeDeleteShape;
                case 5:
                    return WXWBMessageTypeClearAll;
                case 6:
                    return WXWBMessageTypeScroll;
                case 7:
                    return WXWBMessageTypeGeometry;
                default:
                    switch (i) {
                        case 9:
                            return WXWBMessageTypeChoose;
                        case 10:
                            return WXWBMessageTypePointer;
                        case 11:
                            return WXWBMessageTypeRuler;
                        case 12:
                            return WXWBMessageTypeCompass;
                        case 13:
                            return WXWBMessageTypeTimer;
                        case 14:
                            return WXWBMessageTypeUpdateMiniBoard;
                        default:
                            switch (i) {
                                case 16:
                                    return WXWBMessageTypeDeleteMiniBoard;
                                case 17:
                                    return WXWBMessageTypeUpdateCustomView;
                                case 18:
                                    return WXWBMessageTypeBatchAction;
                                case 19:
                                    return WXWBMessageTypeTextBox;
                                case 20:
                                    return WXWBMessageTypeSignalCourseware;
                                default:
                                    return null;
                            }
                    }
            }
        }

        public static Internal.EnumLiteMap<WXWBMessageType> internalGetValueMap() {
            return internalValueMap;
        }

        private WXWBMessageType(int i) {
            this.value = i;
        }
    }

    public enum WXTPointType implements Internal.EnumLite {
        WXWBPointTypePen(0),
        WXWBPointTypeEraser(1),
        WXWBPointTypeLine(2),
        WXWBPointArrowLine(3),
        WXWBPointArrow2Line(4),
        WXWBPointTriangle(5),
        WXWBPointRect(6),
        WXWBPointEllipses(7),
        WXWBPointPrarllelogram(8),
        WXWBPointPolygons(9),
        WXWBPointTypeSelect(10),
        WXWBPointCircle(11),
        WXWBPointRightTriangle(12),
        WXWBPointAxis(13),
        WXWBPointCube(14),
        WXWBPointCylinder(15),
        WXWBPointCone(16),
        WXWBPointDashed(17),
        WXWBPointCoordinate(18),
        WXWBPointAutoShape(19),
        WXWBPointDiamond(20),
        WXWBPointPointer(21),
        WXWBPointIsoscelesTriangle(22),
        WXWBPointLine2(23),
        WXWBPointEllipses2(24),
        WXWBPointTwoCoordinateSystem(30),
        WXWBPointThreeCoordinateSystem(31),
        WXWBPointCurve1(32),
        WXWBPointCurve2(33),
        WXWBPointCurve3(34),
        WXWBPointCurve4(35),
        WXWBPointCurve5(36),
        WXWBPointCurve6(37),
        WXWBPointCurve7(38),
        WXWBPointCurve8(39),
        WXWBPointCurve9(40),
        WXWBPointCurve10(41),
        WXWBPointCurve11(42),
        WXWBPointCurve12(43),
        WXWBPointCurve13(44),
        WXWBPointIsoscelesTrapezoid(45),
        WXWBPointRightTrapezoid(46),
        WXWBPointPentagon(47),
        WXWBPointHexagon(48),
        WXWBPointFrontCube(49),
        WXWBPointSideCube(50),
        WXWBPointRectangularPyramid1(51),
        WXWBPointRriangularPyramid(52),
        WXWBPointTriangularPrism(53),
        WXWBPointCylinderPlatform(54),
        WXWBPointSphere(55),
        WXWBPointCubePlatform(56),
        WXWBPointCorpusTrapezoideum(57),
        WXWBPointTruncatedTriangularPrism(58),
        WXWBPointRectangularPyramid2(59),
        WXWBPointPhysicsCoordinate(60),
        WXWBPointPhysicsVector(61),
        WXWBPointPhysicsSwitch(62),
        WXWBPointPhysicsBattery(63),
        WXWBPointPhysicsLight(64),
        WXWBPointPhysicsAmmeter(65),
        WXWBPointPhysicsVoltmeter(66),
        WXWBPointPhysicsResistance(67),
        WXWBPointPhysicsRheostat(68),
        WXWBPointPhysicsElectromotor(69),
        WXWBPointPhysicsBell(70),
        WXWBPointChemistryElectronic1(71),
        WXWBPointChemistryElectronic2(72),
        WXWBPointChemistryElectronic3(73),
        WXWBPointChemistryCoordinate(74),
        WXWBPointChemistryTestTube(75),
        WXWBPointChemistryBeaker(76),
        WXWBPointChemistryWildMouthBottle(77),
        WXWBPointChemistryConicalFlask(78),
        WXWBPointChemistryFunnel(79),
        WXWBPointChemistryUShapePipe(80),
        WXWBPointChemistryLongNeckFunnel(81),
        WXWBPointChemistrySeparatingFunnel(82),
        WXWBPointChemistryBentPipe(83),
        WXWBPointChemistryElectrolyticTank1(84),
        WXWBPointChemistryElectrolyticTank2(85),
        WXWBPointChemistryElectrolyticTank3(86),
        WXWBPointChemistryBenzeneRing(87),
        WXWBPointChemistryAlcoholLamp(88),
        WXWBPointChemistryGasBottle1(89),
        WXWBPointChemistryGasBottle2(90),
        WXWBPointCustomShapeImage(100),
        WXWBPointFluorescentPen(1000),
        WXWBMessageTypeBatchMove(1001),
        WXWBMessageTypeBatchDelete(1002),
        WXWBMessageTypeBatchCopy(1003),
        UNRECOGNIZED(-1);
        
        public static final int WXWBMessageTypeBatchCopy_VALUE = 1003;
        public static final int WXWBMessageTypeBatchDelete_VALUE = 1002;
        public static final int WXWBMessageTypeBatchMove_VALUE = 1001;
        public static final int WXWBPointArrow2Line_VALUE = 4;
        public static final int WXWBPointArrowLine_VALUE = 3;
        public static final int WXWBPointAutoShape_VALUE = 19;
        public static final int WXWBPointAxis_VALUE = 13;
        public static final int WXWBPointChemistryAlcoholLamp_VALUE = 88;
        public static final int WXWBPointChemistryBeaker_VALUE = 76;
        public static final int WXWBPointChemistryBentPipe_VALUE = 83;
        public static final int WXWBPointChemistryBenzeneRing_VALUE = 87;
        public static final int WXWBPointChemistryConicalFlask_VALUE = 78;
        public static final int WXWBPointChemistryCoordinate_VALUE = 74;
        public static final int WXWBPointChemistryElectrolyticTank1_VALUE = 84;
        public static final int WXWBPointChemistryElectrolyticTank2_VALUE = 85;
        public static final int WXWBPointChemistryElectrolyticTank3_VALUE = 86;
        public static final int WXWBPointChemistryElectronic1_VALUE = 71;
        public static final int WXWBPointChemistryElectronic2_VALUE = 72;
        public static final int WXWBPointChemistryElectronic3_VALUE = 73;
        public static final int WXWBPointChemistryFunnel_VALUE = 79;
        public static final int WXWBPointChemistryGasBottle1_VALUE = 89;
        public static final int WXWBPointChemistryGasBottle2_VALUE = 90;
        public static final int WXWBPointChemistryLongNeckFunnel_VALUE = 81;
        public static final int WXWBPointChemistrySeparatingFunnel_VALUE = 82;
        public static final int WXWBPointChemistryTestTube_VALUE = 75;
        public static final int WXWBPointChemistryUShapePipe_VALUE = 80;
        public static final int WXWBPointChemistryWildMouthBottle_VALUE = 77;
        public static final int WXWBPointCircle_VALUE = 11;
        public static final int WXWBPointCone_VALUE = 16;
        public static final int WXWBPointCoordinate_VALUE = 18;
        public static final int WXWBPointCorpusTrapezoideum_VALUE = 57;
        public static final int WXWBPointCubePlatform_VALUE = 56;
        public static final int WXWBPointCube_VALUE = 14;
        public static final int WXWBPointCurve10_VALUE = 41;
        public static final int WXWBPointCurve11_VALUE = 42;
        public static final int WXWBPointCurve12_VALUE = 43;
        public static final int WXWBPointCurve13_VALUE = 44;
        public static final int WXWBPointCurve1_VALUE = 32;
        public static final int WXWBPointCurve2_VALUE = 33;
        public static final int WXWBPointCurve3_VALUE = 34;
        public static final int WXWBPointCurve4_VALUE = 35;
        public static final int WXWBPointCurve5_VALUE = 36;
        public static final int WXWBPointCurve6_VALUE = 37;
        public static final int WXWBPointCurve7_VALUE = 38;
        public static final int WXWBPointCurve8_VALUE = 39;
        public static final int WXWBPointCurve9_VALUE = 40;
        public static final int WXWBPointCustomShapeImage_VALUE = 100;
        public static final int WXWBPointCylinderPlatform_VALUE = 54;
        public static final int WXWBPointCylinder_VALUE = 15;
        public static final int WXWBPointDashed_VALUE = 17;
        public static final int WXWBPointDiamond_VALUE = 20;
        public static final int WXWBPointEllipses2_VALUE = 24;
        public static final int WXWBPointEllipses_VALUE = 7;
        public static final int WXWBPointFluorescentPen_VALUE = 1000;
        public static final int WXWBPointFrontCube_VALUE = 49;
        public static final int WXWBPointHexagon_VALUE = 48;
        public static final int WXWBPointIsoscelesTrapezoid_VALUE = 45;
        public static final int WXWBPointIsoscelesTriangle_VALUE = 22;
        public static final int WXWBPointLine2_VALUE = 23;
        public static final int WXWBPointPentagon_VALUE = 47;
        public static final int WXWBPointPhysicsAmmeter_VALUE = 65;
        public static final int WXWBPointPhysicsBattery_VALUE = 63;
        public static final int WXWBPointPhysicsBell_VALUE = 70;
        public static final int WXWBPointPhysicsCoordinate_VALUE = 60;
        public static final int WXWBPointPhysicsElectromotor_VALUE = 69;
        public static final int WXWBPointPhysicsLight_VALUE = 64;
        public static final int WXWBPointPhysicsResistance_VALUE = 67;
        public static final int WXWBPointPhysicsRheostat_VALUE = 68;
        public static final int WXWBPointPhysicsSwitch_VALUE = 62;
        public static final int WXWBPointPhysicsVector_VALUE = 61;
        public static final int WXWBPointPhysicsVoltmeter_VALUE = 66;
        public static final int WXWBPointPointer_VALUE = 21;
        public static final int WXWBPointPolygons_VALUE = 9;
        public static final int WXWBPointPrarllelogram_VALUE = 8;
        public static final int WXWBPointRect_VALUE = 6;
        public static final int WXWBPointRectangularPyramid1_VALUE = 51;
        public static final int WXWBPointRectangularPyramid2_VALUE = 59;
        public static final int WXWBPointRightTrapezoid_VALUE = 46;
        public static final int WXWBPointRightTriangle_VALUE = 12;
        public static final int WXWBPointRriangularPyramid_VALUE = 52;
        public static final int WXWBPointSideCube_VALUE = 50;
        public static final int WXWBPointSphere_VALUE = 55;
        public static final int WXWBPointThreeCoordinateSystem_VALUE = 31;
        public static final int WXWBPointTriangle_VALUE = 5;
        public static final int WXWBPointTriangularPrism_VALUE = 53;
        public static final int WXWBPointTruncatedTriangularPrism_VALUE = 58;
        public static final int WXWBPointTwoCoordinateSystem_VALUE = 30;
        public static final int WXWBPointTypeEraser_VALUE = 1;
        public static final int WXWBPointTypeLine_VALUE = 2;
        public static final int WXWBPointTypePen_VALUE = 0;
        public static final int WXWBPointTypeSelect_VALUE = 10;
        private static final Internal.EnumLiteMap<WXTPointType> internalValueMap = null;
        private final int value;

        static {
            internalValueMap = new Internal.EnumLiteMap<WXTPointType>() {
                public WXTPointType findValueByNumber(int i) {
                    return WXTPointType.forNumber(i);
                }
            };
        }

        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static WXTPointType valueOf(int i) {
            return forNumber(i);
        }

        public static WXTPointType forNumber(int i) {
            if (i == 100) {
                return WXWBPointCustomShapeImage;
            }
            switch (i) {
                case 0:
                    return WXWBPointTypePen;
                case 1:
                    return WXWBPointTypeEraser;
                case 2:
                    return WXWBPointTypeLine;
                case 3:
                    return WXWBPointArrowLine;
                case 4:
                    return WXWBPointArrow2Line;
                case 5:
                    return WXWBPointTriangle;
                case 6:
                    return WXWBPointRect;
                case 7:
                    return WXWBPointEllipses;
                case 8:
                    return WXWBPointPrarllelogram;
                case 9:
                    return WXWBPointPolygons;
                case 10:
                    return WXWBPointTypeSelect;
                case 11:
                    return WXWBPointCircle;
                case 12:
                    return WXWBPointRightTriangle;
                case 13:
                    return WXWBPointAxis;
                case 14:
                    return WXWBPointCube;
                case 15:
                    return WXWBPointCylinder;
                case 16:
                    return WXWBPointCone;
                case 17:
                    return WXWBPointDashed;
                case 18:
                    return WXWBPointCoordinate;
                case 19:
                    return WXWBPointAutoShape;
                case 20:
                    return WXWBPointDiamond;
                case 21:
                    return WXWBPointPointer;
                case 22:
                    return WXWBPointIsoscelesTriangle;
                case 23:
                    return WXWBPointLine2;
                case 24:
                    return WXWBPointEllipses2;
                default:
                    switch (i) {
                        case 30:
                            return WXWBPointTwoCoordinateSystem;
                        case 31:
                            return WXWBPointThreeCoordinateSystem;
                        case 32:
                            return WXWBPointCurve1;
                        case 33:
                            return WXWBPointCurve2;
                        case 34:
                            return WXWBPointCurve3;
                        case 35:
                            return WXWBPointCurve4;
                        case 36:
                            return WXWBPointCurve5;
                        case 37:
                            return WXWBPointCurve6;
                        case 38:
                            return WXWBPointCurve7;
                        case 39:
                            return WXWBPointCurve8;
                        case 40:
                            return WXWBPointCurve9;
                        case 41:
                            return WXWBPointCurve10;
                        case 42:
                            return WXWBPointCurve11;
                        case 43:
                            return WXWBPointCurve12;
                        case 44:
                            return WXWBPointCurve13;
                        case 45:
                            return WXWBPointIsoscelesTrapezoid;
                        case 46:
                            return WXWBPointRightTrapezoid;
                        case 47:
                            return WXWBPointPentagon;
                        case 48:
                            return WXWBPointHexagon;
                        case 49:
                            return WXWBPointFrontCube;
                        case 50:
                            return WXWBPointSideCube;
                        case 51:
                            return WXWBPointRectangularPyramid1;
                        case 52:
                            return WXWBPointRriangularPyramid;
                        case 53:
                            return WXWBPointTriangularPrism;
                        case 54:
                            return WXWBPointCylinderPlatform;
                        case 55:
                            return WXWBPointSphere;
                        case 56:
                            return WXWBPointCubePlatform;
                        case 57:
                            return WXWBPointCorpusTrapezoideum;
                        case 58:
                            return WXWBPointTruncatedTriangularPrism;
                        case 59:
                            return WXWBPointRectangularPyramid2;
                        case 60:
                            return WXWBPointPhysicsCoordinate;
                        case 61:
                            return WXWBPointPhysicsVector;
                        case 62:
                            return WXWBPointPhysicsSwitch;
                        case 63:
                            return WXWBPointPhysicsBattery;
                        case 64:
                            return WXWBPointPhysicsLight;
                        case 65:
                            return WXWBPointPhysicsAmmeter;
                        case 66:
                            return WXWBPointPhysicsVoltmeter;
                        case 67:
                            return WXWBPointPhysicsResistance;
                        case 68:
                            return WXWBPointPhysicsRheostat;
                        case 69:
                            return WXWBPointPhysicsElectromotor;
                        case 70:
                            return WXWBPointPhysicsBell;
                        case 71:
                            return WXWBPointChemistryElectronic1;
                        case 72:
                            return WXWBPointChemistryElectronic2;
                        case 73:
                            return WXWBPointChemistryElectronic3;
                        case 74:
                            return WXWBPointChemistryCoordinate;
                        case 75:
                            return WXWBPointChemistryTestTube;
                        case 76:
                            return WXWBPointChemistryBeaker;
                        case 77:
                            return WXWBPointChemistryWildMouthBottle;
                        case 78:
                            return WXWBPointChemistryConicalFlask;
                        case 79:
                            return WXWBPointChemistryFunnel;
                        case 80:
                            return WXWBPointChemistryUShapePipe;
                        case 81:
                            return WXWBPointChemistryLongNeckFunnel;
                        case 82:
                            return WXWBPointChemistrySeparatingFunnel;
                        case 83:
                            return WXWBPointChemistryBentPipe;
                        case 84:
                            return WXWBPointChemistryElectrolyticTank1;
                        case 85:
                            return WXWBPointChemistryElectrolyticTank2;
                        case 86:
                            return WXWBPointChemistryElectrolyticTank3;
                        case 87:
                            return WXWBPointChemistryBenzeneRing;
                        case 88:
                            return WXWBPointChemistryAlcoholLamp;
                        case 89:
                            return WXWBPointChemistryGasBottle1;
                        case 90:
                            return WXWBPointChemistryGasBottle2;
                        default:
                            switch (i) {
                                case 1000:
                                    return WXWBPointFluorescentPen;
                                case 1001:
                                    return WXWBMessageTypeBatchMove;
                                case 1002:
                                    return WXWBMessageTypeBatchDelete;
                                case 1003:
                                    return WXWBMessageTypeBatchCopy;
                                default:
                                    return null;
                            }
                    }
            }
        }

        public static Internal.EnumLiteMap<WXTPointType> internalGetValueMap() {
            return internalValueMap;
        }

        private WXTPointType(int i) {
            this.value = i;
        }
    }

    public enum WXWBPointAction implements Internal.EnumLite {
        WXWBPointActionStart(0),
        WXWBPointActionMove(1),
        WXWBPointActionEnd(2),
        UNRECOGNIZED(-1);
        
        public static final int WXWBPointActionEnd_VALUE = 2;
        public static final int WXWBPointActionMove_VALUE = 1;
        public static final int WXWBPointActionStart_VALUE = 0;
        private static final Internal.EnumLiteMap<WXWBPointAction> internalValueMap = null;
        private final int value;

        static {
            internalValueMap = new Internal.EnumLiteMap<WXWBPointAction>() {
                public WXWBPointAction findValueByNumber(int i) {
                    return WXWBPointAction.forNumber(i);
                }
            };
        }

        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static WXWBPointAction valueOf(int i) {
            return forNumber(i);
        }

        public static WXWBPointAction forNumber(int i) {
            if (i == 0) {
                return WXWBPointActionStart;
            }
            if (i == 1) {
                return WXWBPointActionMove;
            }
            if (i != 2) {
                return null;
            }
            return WXWBPointActionEnd;
        }

        public static Internal.EnumLiteMap<WXWBPointAction> internalGetValueMap() {
            return internalValueMap;
        }

        private WXWBPointAction(int i) {
            this.value = i;
        }
    }

    public enum WXWBLineType implements Internal.EnumLite {
        WXWBLineTypeSolid(0),
        WXWBLineTypeDashed(1),
        WXWBLineTypeDotted(2),
        WXWBLineTypeDashed2(3),
        UNRECOGNIZED(-1);
        
        public static final int WXWBLineTypeDashed2_VALUE = 3;
        public static final int WXWBLineTypeDashed_VALUE = 1;
        public static final int WXWBLineTypeDotted_VALUE = 2;
        public static final int WXWBLineTypeSolid_VALUE = 0;
        private static final Internal.EnumLiteMap<WXWBLineType> internalValueMap = null;
        private final int value;

        static {
            internalValueMap = new Internal.EnumLiteMap<WXWBLineType>() {
                public WXWBLineType findValueByNumber(int i) {
                    return WXWBLineType.forNumber(i);
                }
            };
        }

        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static WXWBLineType valueOf(int i) {
            return forNumber(i);
        }

        public static WXWBLineType forNumber(int i) {
            if (i == 0) {
                return WXWBLineTypeSolid;
            }
            if (i == 1) {
                return WXWBLineTypeDashed;
            }
            if (i == 2) {
                return WXWBLineTypeDotted;
            }
            if (i != 3) {
                return null;
            }
            return WXWBLineTypeDashed2;
        }

        public static Internal.EnumLiteMap<WXWBLineType> internalGetValueMap() {
            return internalValueMap;
        }

        private WXWBLineType(int i) {
            this.value = i;
        }
    }

    public static final class WXWBPageConfig extends GeneratedMessageLite<WXWBPageConfig, Builder> implements WXWBPageConfigOrBuilder {
        public static final int CURRENTPAGE_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final WXWBPageConfig DEFAULT_INSTANCE;
        public static final int PAGELIST_FIELD_NUMBER = 2;
        private static volatile Parser<WXWBPageConfig> PARSER;
        private int bitField0_;
        private String currentPage_ = "";
        private Internal.ProtobufList<String> pageList_ = GeneratedMessageLite.emptyProtobufList();

        private WXWBPageConfig() {
        }

        public String getCurrentPage() {
            return this.currentPage_;
        }

        public ByteString getCurrentPageBytes() {
            return ByteString.copyFromUtf8(this.currentPage_);
        }

        /* access modifiers changed from: private */
        public void setCurrentPage(String str) {
            Objects.requireNonNull(str);
            this.currentPage_ = str;
        }

        /* access modifiers changed from: private */
        public void clearCurrentPage() {
            this.currentPage_ = getDefaultInstance().getCurrentPage();
        }

        /* access modifiers changed from: private */
        public void setCurrentPageBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            checkByteStringIsUtf8(byteString);
            this.currentPage_ = byteString.toStringUtf8();
        }

        public List<String> getPageListList() {
            return this.pageList_;
        }

        public int getPageListCount() {
            return this.pageList_.size();
        }

        public String getPageList(int i) {
            return (String) this.pageList_.get(i);
        }

        public ByteString getPageListBytes(int i) {
            return ByteString.copyFromUtf8((String) this.pageList_.get(i));
        }

        private void ensurePageListIsMutable() {
            if (!this.pageList_.isModifiable()) {
                this.pageList_ = GeneratedMessageLite.mutableCopy(this.pageList_);
            }
        }

        /* access modifiers changed from: private */
        public void setPageList(int i, String str) {
            Objects.requireNonNull(str);
            ensurePageListIsMutable();
            this.pageList_.set(i, str);
        }

        /* access modifiers changed from: private */
        public void addPageList(String str) {
            Objects.requireNonNull(str);
            ensurePageListIsMutable();
            this.pageList_.add(str);
        }

        /* access modifiers changed from: private */
        public void addAllPageList(Iterable<String> iterable) {
            ensurePageListIsMutable();
            AbstractMessageLite.addAll(iterable, this.pageList_);
        }

        /* access modifiers changed from: private */
        public void clearPageList() {
            this.pageList_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void addPageListBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            checkByteStringIsUtf8(byteString);
            ensurePageListIsMutable();
            this.pageList_.add(byteString.toStringUtf8());
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.currentPage_.isEmpty()) {
                codedOutputStream.writeString(1, getCurrentPage());
            }
            for (int i = 0; i < this.pageList_.size(); i++) {
                codedOutputStream.writeString(2, (String) this.pageList_.get(i));
            }
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeStringSize = !this.currentPage_.isEmpty() ? CodedOutputStream.computeStringSize(1, getCurrentPage()) + 0 : 0;
            int i2 = 0;
            for (int i3 = 0; i3 < this.pageList_.size(); i3++) {
                i2 += CodedOutputStream.computeStringSizeNoTag((String) this.pageList_.get(i3));
            }
            int size = computeStringSize + i2 + (getPageListList().size() * 1);
            this.memoizedSerializedSize = size;
            return size;
        }

        public static WXWBPageConfig parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static WXWBPageConfig parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static WXWBPageConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static WXWBPageConfig parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static WXWBPageConfig parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WXWBPageConfig parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WXWBPageConfig parseDelimitedFrom(InputStream inputStream) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WXWBPageConfig parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WXWBPageConfig parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static WXWBPageConfig parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WXWBPageConfig wXWBPageConfig) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(wXWBPageConfig);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<WXWBPageConfig, Builder> implements WXWBPageConfigOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(WXWBPageConfig.DEFAULT_INSTANCE);
            }

            public String getCurrentPage() {
                return this.instance.getCurrentPage();
            }

            public ByteString getCurrentPageBytes() {
                return this.instance.getCurrentPageBytes();
            }

            public Builder setCurrentPage(String str) {
                copyOnWrite();
                this.instance.setCurrentPage(str);
                return this;
            }

            public Builder clearCurrentPage() {
                copyOnWrite();
                this.instance.clearCurrentPage();
                return this;
            }

            public Builder setCurrentPageBytes(ByteString byteString) {
                copyOnWrite();
                this.instance.setCurrentPageBytes(byteString);
                return this;
            }

            public List<String> getPageListList() {
                return Collections.unmodifiableList(this.instance.getPageListList());
            }

            public int getPageListCount() {
                return this.instance.getPageListCount();
            }

            public String getPageList(int i) {
                return this.instance.getPageList(i);
            }

            public ByteString getPageListBytes(int i) {
                return this.instance.getPageListBytes(i);
            }

            public Builder setPageList(int i, String str) {
                copyOnWrite();
                this.instance.setPageList(i, str);
                return this;
            }

            public Builder addPageList(String str) {
                copyOnWrite();
                this.instance.addPageList(str);
                return this;
            }

            public Builder addAllPageList(Iterable<String> iterable) {
                copyOnWrite();
                this.instance.addAllPageList(iterable);
                return this;
            }

            public Builder clearPageList() {
                copyOnWrite();
                this.instance.clearPageList();
                return this;
            }

            public Builder addPageListBytes(ByteString byteString) {
                copyOnWrite();
                this.instance.addPageListBytes(byteString);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new WXWBPageConfig();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.pageList_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = (GeneratedMessageLite.Visitor) obj;
                    WXWBPageConfig wXWBPageConfig = (WXWBPageConfig) obj2;
                    this.currentPage_ = mergeFromVisitor.visitString(!this.currentPage_.isEmpty(), this.currentPage_, true ^ wXWBPageConfig.currentPage_.isEmpty(), wXWBPageConfig.currentPage_);
                    this.pageList_ = mergeFromVisitor.visitList(this.pageList_, wXWBPageConfig.pageList_);
                    if (mergeFromVisitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= wXWBPageConfig.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    boolean z = false;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.currentPage_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 18) {
                                    String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.pageList_.isModifiable()) {
                                        this.pageList_ = GeneratedMessageLite.mutableCopy(this.pageList_);
                                    }
                                    this.pageList_.add(readStringRequireUtf8);
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (WXWBPageConfig.class) {
                            if (PARSER == null) {
                                PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }
                    return PARSER;
                default:
                    throw new UnsupportedOperationException();
            }
            return DEFAULT_INSTANCE;
        }

        static {
            WXWBPageConfig wXWBPageConfig = new WXWBPageConfig();
            DEFAULT_INSTANCE = wXWBPageConfig;
            wXWBPageConfig.makeImmutable();
        }

        public static WXWBPageConfig getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WXWBPageConfig> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    /* renamed from: com.xueersi.lib.graffiti.protobean.WXWBTCPPacketDataOuterClass$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke[] r0 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke = r0
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.IS_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.MAKE_IMMUTABLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.NEW_BUILDER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.VISIT     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.MERGE_FROM_STREAM     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.google.protobuf.GeneratedMessageLite$MethodToInvoke r1 = com.google.protobuf.GeneratedMessageLite.MethodToInvoke.GET_PARSER     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xueersi.lib.graffiti.protobean.WXWBTCPPacketDataOuterClass.AnonymousClass1.<clinit>():void");
        }
    }

    public static final class WXWBRulerConfig extends GeneratedMessageLite<WXWBRulerConfig, Builder> implements WXWBRulerConfigOrBuilder {
        /* access modifiers changed from: private */
        public static final WXWBRulerConfig DEFAULT_INSTANCE;
        public static final int ENABLE_FIELD_NUMBER = 1;
        public static final int LEFT_FIELD_NUMBER = 2;
        public static final int LENGTH_FIELD_NUMBER = 4;
        private static volatile Parser<WXWBRulerConfig> PARSER = null;
        public static final int ROTATE_FIELD_NUMBER = 5;
        public static final int TOP_FIELD_NUMBER = 3;
        private boolean enable_;
        private float left_;
        private float length_;
        private float rotate_;
        private float top_;

        private WXWBRulerConfig() {
        }

        public boolean getEnable() {
            return this.enable_;
        }

        /* access modifiers changed from: private */
        public void setEnable(boolean z) {
            this.enable_ = z;
        }

        /* access modifiers changed from: private */
        public void clearEnable() {
            this.enable_ = false;
        }

        public float getLeft() {
            return this.left_;
        }

        /* access modifiers changed from: private */
        public void setLeft(float f) {
            this.left_ = f;
        }

        /* access modifiers changed from: private */
        public void clearLeft() {
            this.left_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public float getTop() {
            return this.top_;
        }

        /* access modifiers changed from: private */
        public void setTop(float f) {
            this.top_ = f;
        }

        /* access modifiers changed from: private */
        public void clearTop() {
            this.top_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public float getLength() {
            return this.length_;
        }

        /* access modifiers changed from: private */
        public void setLength(float f) {
            this.length_ = f;
        }

        /* access modifiers changed from: private */
        public void clearLength() {
            this.length_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public float getRotate() {
            return this.rotate_;
        }

        /* access modifiers changed from: private */
        public void setRotate(float f) {
            this.rotate_ = f;
        }

        /* access modifiers changed from: private */
        public void clearRotate() {
            this.rotate_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            boolean z = this.enable_;
            if (z) {
                codedOutputStream.writeBool(1, z);
            }
            float f = this.left_;
            if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(2, f);
            }
            float f2 = this.top_;
            if (f2 != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(3, f2);
            }
            float f3 = this.length_;
            if (f3 != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(4, f3);
            }
            float f4 = this.rotate_;
            if (f4 != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(5, f4);
            }
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            boolean z = this.enable_;
            if (z) {
                i2 = 0 + CodedOutputStream.computeBoolSize(1, z);
            }
            float f = this.left_;
            if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += CodedOutputStream.computeFloatSize(2, f);
            }
            float f2 = this.top_;
            if (f2 != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += CodedOutputStream.computeFloatSize(3, f2);
            }
            float f3 = this.length_;
            if (f3 != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += CodedOutputStream.computeFloatSize(4, f3);
            }
            float f4 = this.rotate_;
            if (f4 != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += CodedOutputStream.computeFloatSize(5, f4);
            }
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public static WXWBRulerConfig parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static WXWBRulerConfig parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static WXWBRulerConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static WXWBRulerConfig parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static WXWBRulerConfig parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WXWBRulerConfig parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WXWBRulerConfig parseDelimitedFrom(InputStream inputStream) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WXWBRulerConfig parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WXWBRulerConfig parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static WXWBRulerConfig parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WXWBRulerConfig wXWBRulerConfig) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(wXWBRulerConfig);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<WXWBRulerConfig, Builder> implements WXWBRulerConfigOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(WXWBRulerConfig.DEFAULT_INSTANCE);
            }

            public boolean getEnable() {
                return this.instance.getEnable();
            }

            public Builder setEnable(boolean z) {
                copyOnWrite();
                this.instance.setEnable(z);
                return this;
            }

            public Builder clearEnable() {
                copyOnWrite();
                this.instance.clearEnable();
                return this;
            }

            public float getLeft() {
                return this.instance.getLeft();
            }

            public Builder setLeft(float f) {
                copyOnWrite();
                this.instance.setLeft(f);
                return this;
            }

            public Builder clearLeft() {
                copyOnWrite();
                this.instance.clearLeft();
                return this;
            }

            public float getTop() {
                return this.instance.getTop();
            }

            public Builder setTop(float f) {
                copyOnWrite();
                this.instance.setTop(f);
                return this;
            }

            public Builder clearTop() {
                copyOnWrite();
                this.instance.clearTop();
                return this;
            }

            public float getLength() {
                return this.instance.getLength();
            }

            public Builder setLength(float f) {
                copyOnWrite();
                this.instance.setLength(f);
                return this;
            }

            public Builder clearLength() {
                copyOnWrite();
                this.instance.clearLength();
                return this;
            }

            public float getRotate() {
                return this.instance.getRotate();
            }

            public Builder setRotate(float f) {
                copyOnWrite();
                this.instance.setRotate(f);
                return this;
            }

            public Builder clearRotate() {
                copyOnWrite();
                this.instance.clearRotate();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new WXWBRulerConfig();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    WXWBRulerConfig wXWBRulerConfig = (WXWBRulerConfig) obj2;
                    boolean z2 = this.enable_;
                    boolean z3 = wXWBRulerConfig.enable_;
                    this.enable_ = visitor.visitBoolean(z2, z2, z3, z3);
                    float f = this.left_;
                    boolean z4 = f != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f2 = wXWBRulerConfig.left_;
                    this.left_ = visitor.visitFloat(z4, f, f2 != CropImageView.DEFAULT_ASPECT_RATIO, f2);
                    float f3 = this.top_;
                    boolean z5 = f3 != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f4 = wXWBRulerConfig.top_;
                    this.top_ = visitor.visitFloat(z5, f3, f4 != CropImageView.DEFAULT_ASPECT_RATIO, f4);
                    float f5 = this.length_;
                    boolean z6 = f5 != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f6 = wXWBRulerConfig.length_;
                    this.length_ = visitor.visitFloat(z6, f5, f6 != CropImageView.DEFAULT_ASPECT_RATIO, f6);
                    float f7 = this.rotate_;
                    boolean z7 = f7 != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f8 = wXWBRulerConfig.rotate_;
                    if (f8 != CropImageView.DEFAULT_ASPECT_RATIO) {
                        z = true;
                    }
                    this.rotate_ = visitor.visitFloat(z7, f7, z, f8);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.enable_ = codedInputStream.readBool();
                                } else if (readTag == 21) {
                                    this.left_ = codedInputStream.readFloat();
                                } else if (readTag == 29) {
                                    this.top_ = codedInputStream.readFloat();
                                } else if (readTag == 37) {
                                    this.length_ = codedInputStream.readFloat();
                                } else if (readTag == 45) {
                                    this.rotate_ = codedInputStream.readFloat();
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (WXWBRulerConfig.class) {
                            if (PARSER == null) {
                                PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }
                    return PARSER;
                default:
                    throw new UnsupportedOperationException();
            }
            return DEFAULT_INSTANCE;
        }

        static {
            WXWBRulerConfig wXWBRulerConfig = new WXWBRulerConfig();
            DEFAULT_INSTANCE = wXWBRulerConfig;
            wXWBRulerConfig.makeImmutable();
        }

        public static WXWBRulerConfig getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WXWBRulerConfig> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class WXWBCompassesConfig extends GeneratedMessageLite<WXWBCompassesConfig, Builder> implements WXWBCompassesConfigOrBuilder {
        /* access modifiers changed from: private */
        public static final WXWBCompassesConfig DEFAULT_INSTANCE;
        public static final int ENABLE_FIELD_NUMBER = 1;
        public static final int LEFT_FIELD_NUMBER = 2;
        private static volatile Parser<WXWBCompassesConfig> PARSER = null;
        public static final int RADIUS_FIELD_NUMBER = 4;
        public static final int ROTATE_FIELD_NUMBER = 5;
        public static final int TOP_FIELD_NUMBER = 3;
        private boolean enable_;
        private float left_;
        private float radius_;
        private float rotate_;
        private float top_;

        private WXWBCompassesConfig() {
        }

        public boolean getEnable() {
            return this.enable_;
        }

        /* access modifiers changed from: private */
        public void setEnable(boolean z) {
            this.enable_ = z;
        }

        /* access modifiers changed from: private */
        public void clearEnable() {
            this.enable_ = false;
        }

        public float getLeft() {
            return this.left_;
        }

        /* access modifiers changed from: private */
        public void setLeft(float f) {
            this.left_ = f;
        }

        /* access modifiers changed from: private */
        public void clearLeft() {
            this.left_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public float getTop() {
            return this.top_;
        }

        /* access modifiers changed from: private */
        public void setTop(float f) {
            this.top_ = f;
        }

        /* access modifiers changed from: private */
        public void clearTop() {
            this.top_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public float getRadius() {
            return this.radius_;
        }

        /* access modifiers changed from: private */
        public void setRadius(float f) {
            this.radius_ = f;
        }

        /* access modifiers changed from: private */
        public void clearRadius() {
            this.radius_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public float getRotate() {
            return this.rotate_;
        }

        /* access modifiers changed from: private */
        public void setRotate(float f) {
            this.rotate_ = f;
        }

        /* access modifiers changed from: private */
        public void clearRotate() {
            this.rotate_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            boolean z = this.enable_;
            if (z) {
                codedOutputStream.writeBool(1, z);
            }
            float f = this.left_;
            if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(2, f);
            }
            float f2 = this.top_;
            if (f2 != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(3, f2);
            }
            float f3 = this.radius_;
            if (f3 != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(4, f3);
            }
            float f4 = this.rotate_;
            if (f4 != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(5, f4);
            }
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            boolean z = this.enable_;
            if (z) {
                i2 = 0 + CodedOutputStream.computeBoolSize(1, z);
            }
            float f = this.left_;
            if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += CodedOutputStream.computeFloatSize(2, f);
            }
            float f2 = this.top_;
            if (f2 != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += CodedOutputStream.computeFloatSize(3, f2);
            }
            float f3 = this.radius_;
            if (f3 != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += CodedOutputStream.computeFloatSize(4, f3);
            }
            float f4 = this.rotate_;
            if (f4 != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += CodedOutputStream.computeFloatSize(5, f4);
            }
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public static WXWBCompassesConfig parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static WXWBCompassesConfig parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static WXWBCompassesConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static WXWBCompassesConfig parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static WXWBCompassesConfig parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WXWBCompassesConfig parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WXWBCompassesConfig parseDelimitedFrom(InputStream inputStream) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WXWBCompassesConfig parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WXWBCompassesConfig parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static WXWBCompassesConfig parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WXWBCompassesConfig wXWBCompassesConfig) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(wXWBCompassesConfig);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<WXWBCompassesConfig, Builder> implements WXWBCompassesConfigOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(WXWBCompassesConfig.DEFAULT_INSTANCE);
            }

            public boolean getEnable() {
                return this.instance.getEnable();
            }

            public Builder setEnable(boolean z) {
                copyOnWrite();
                this.instance.setEnable(z);
                return this;
            }

            public Builder clearEnable() {
                copyOnWrite();
                this.instance.clearEnable();
                return this;
            }

            public float getLeft() {
                return this.instance.getLeft();
            }

            public Builder setLeft(float f) {
                copyOnWrite();
                this.instance.setLeft(f);
                return this;
            }

            public Builder clearLeft() {
                copyOnWrite();
                this.instance.clearLeft();
                return this;
            }

            public float getTop() {
                return this.instance.getTop();
            }

            public Builder setTop(float f) {
                copyOnWrite();
                this.instance.setTop(f);
                return this;
            }

            public Builder clearTop() {
                copyOnWrite();
                this.instance.clearTop();
                return this;
            }

            public float getRadius() {
                return this.instance.getRadius();
            }

            public Builder setRadius(float f) {
                copyOnWrite();
                this.instance.setRadius(f);
                return this;
            }

            public Builder clearRadius() {
                copyOnWrite();
                this.instance.clearRadius();
                return this;
            }

            public float getRotate() {
                return this.instance.getRotate();
            }

            public Builder setRotate(float f) {
                copyOnWrite();
                this.instance.setRotate(f);
                return this;
            }

            public Builder clearRotate() {
                copyOnWrite();
                this.instance.clearRotate();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new WXWBCompassesConfig();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    WXWBCompassesConfig wXWBCompassesConfig = (WXWBCompassesConfig) obj2;
                    boolean z2 = this.enable_;
                    boolean z3 = wXWBCompassesConfig.enable_;
                    this.enable_ = visitor.visitBoolean(z2, z2, z3, z3);
                    float f = this.left_;
                    boolean z4 = f != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f2 = wXWBCompassesConfig.left_;
                    this.left_ = visitor.visitFloat(z4, f, f2 != CropImageView.DEFAULT_ASPECT_RATIO, f2);
                    float f3 = this.top_;
                    boolean z5 = f3 != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f4 = wXWBCompassesConfig.top_;
                    this.top_ = visitor.visitFloat(z5, f3, f4 != CropImageView.DEFAULT_ASPECT_RATIO, f4);
                    float f5 = this.radius_;
                    boolean z6 = f5 != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f6 = wXWBCompassesConfig.radius_;
                    this.radius_ = visitor.visitFloat(z6, f5, f6 != CropImageView.DEFAULT_ASPECT_RATIO, f6);
                    float f7 = this.rotate_;
                    boolean z7 = f7 != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f8 = wXWBCompassesConfig.rotate_;
                    if (f8 != CropImageView.DEFAULT_ASPECT_RATIO) {
                        z = true;
                    }
                    this.rotate_ = visitor.visitFloat(z7, f7, z, f8);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.enable_ = codedInputStream.readBool();
                                } else if (readTag == 21) {
                                    this.left_ = codedInputStream.readFloat();
                                } else if (readTag == 29) {
                                    this.top_ = codedInputStream.readFloat();
                                } else if (readTag == 37) {
                                    this.radius_ = codedInputStream.readFloat();
                                } else if (readTag == 45) {
                                    this.rotate_ = codedInputStream.readFloat();
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (WXWBCompassesConfig.class) {
                            if (PARSER == null) {
                                PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }
                    return PARSER;
                default:
                    throw new UnsupportedOperationException();
            }
            return DEFAULT_INSTANCE;
        }

        static {
            WXWBCompassesConfig wXWBCompassesConfig = new WXWBCompassesConfig();
            DEFAULT_INSTANCE = wXWBCompassesConfig;
            wXWBCompassesConfig.makeImmutable();
        }

        public static WXWBCompassesConfig getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WXWBCompassesConfig> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class WXWBChooseConfig extends GeneratedMessageLite<WXWBChooseConfig, Builder> implements WXWBChooseConfigOrBuilder {
        /* access modifiers changed from: private */
        public static final WXWBChooseConfig DEFAULT_INSTANCE;
        private static volatile Parser<WXWBChooseConfig> PARSER = null;
        public static final int SELECTENDX_FIELD_NUMBER = 7;
        public static final int SELECTENDY_FIELD_NUMBER = 8;
        public static final int SELECTLINECOLOR_FIELD_NUMBER = 3;
        public static final int SELECTLINETYPE_FIELD_NUMBER = 4;
        public static final int SELECTLINEWIDTH_FIELD_NUMBER = 2;
        public static final int SELECTSHAPE_FIELD_NUMBER = 1;
        public static final int SELECTSTARTX_FIELD_NUMBER = 5;
        public static final int SELECTSTARTY_FIELD_NUMBER = 6;
        private int bitField0_;
        private float selectEndX_;
        private float selectEndY_;
        private String selectLineColor_ = "";
        private int selectLineType_;
        private int selectLineWidth_;
        private Internal.IntList selectShape_ = emptyIntList();
        private float selectStartX_;
        private float selectStartY_;

        private WXWBChooseConfig() {
        }

        public List<Integer> getSelectShapeList() {
            return this.selectShape_;
        }

        public int getSelectShapeCount() {
            return this.selectShape_.size();
        }

        public int getSelectShape(int i) {
            return this.selectShape_.getInt(i);
        }

        private void ensureSelectShapeIsMutable() {
            if (!this.selectShape_.isModifiable()) {
                this.selectShape_ = GeneratedMessageLite.mutableCopy(this.selectShape_);
            }
        }

        /* access modifiers changed from: private */
        public void setSelectShape(int i, int i2) {
            ensureSelectShapeIsMutable();
            this.selectShape_.setInt(i, i2);
        }

        /* access modifiers changed from: private */
        public void addSelectShape(int i) {
            ensureSelectShapeIsMutable();
            this.selectShape_.addInt(i);
        }

        /* access modifiers changed from: private */
        public void addAllSelectShape(Iterable<? extends Integer> iterable) {
            ensureSelectShapeIsMutable();
            AbstractMessageLite.addAll(iterable, this.selectShape_);
        }

        /* access modifiers changed from: private */
        public void clearSelectShape() {
            this.selectShape_ = emptyIntList();
        }

        public int getSelectLineWidth() {
            return this.selectLineWidth_;
        }

        /* access modifiers changed from: private */
        public void setSelectLineWidth(int i) {
            this.selectLineWidth_ = i;
        }

        /* access modifiers changed from: private */
        public void clearSelectLineWidth() {
            this.selectLineWidth_ = 0;
        }

        public String getSelectLineColor() {
            return this.selectLineColor_;
        }

        public ByteString getSelectLineColorBytes() {
            return ByteString.copyFromUtf8(this.selectLineColor_);
        }

        /* access modifiers changed from: private */
        public void setSelectLineColor(String str) {
            Objects.requireNonNull(str);
            this.selectLineColor_ = str;
        }

        /* access modifiers changed from: private */
        public void clearSelectLineColor() {
            this.selectLineColor_ = getDefaultInstance().getSelectLineColor();
        }

        /* access modifiers changed from: private */
        public void setSelectLineColorBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            checkByteStringIsUtf8(byteString);
            this.selectLineColor_ = byteString.toStringUtf8();
        }

        public int getSelectLineType() {
            return this.selectLineType_;
        }

        /* access modifiers changed from: private */
        public void setSelectLineType(int i) {
            this.selectLineType_ = i;
        }

        /* access modifiers changed from: private */
        public void clearSelectLineType() {
            this.selectLineType_ = 0;
        }

        public float getSelectStartX() {
            return this.selectStartX_;
        }

        /* access modifiers changed from: private */
        public void setSelectStartX(float f) {
            this.selectStartX_ = f;
        }

        /* access modifiers changed from: private */
        public void clearSelectStartX() {
            this.selectStartX_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public float getSelectStartY() {
            return this.selectStartY_;
        }

        /* access modifiers changed from: private */
        public void setSelectStartY(float f) {
            this.selectStartY_ = f;
        }

        /* access modifiers changed from: private */
        public void clearSelectStartY() {
            this.selectStartY_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public float getSelectEndX() {
            return this.selectEndX_;
        }

        /* access modifiers changed from: private */
        public void setSelectEndX(float f) {
            this.selectEndX_ = f;
        }

        /* access modifiers changed from: private */
        public void clearSelectEndX() {
            this.selectEndX_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public float getSelectEndY() {
            return this.selectEndY_;
        }

        /* access modifiers changed from: private */
        public void setSelectEndY(float f) {
            this.selectEndY_ = f;
        }

        /* access modifiers changed from: private */
        public void clearSelectEndY() {
            this.selectEndY_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.selectShape_.size(); i++) {
                codedOutputStream.writeInt32(1, this.selectShape_.getInt(i));
            }
            int i2 = this.selectLineWidth_;
            if (i2 != 0) {
                codedOutputStream.writeUInt32(2, i2);
            }
            if (!this.selectLineColor_.isEmpty()) {
                codedOutputStream.writeString(3, getSelectLineColor());
            }
            int i3 = this.selectLineType_;
            if (i3 != 0) {
                codedOutputStream.writeUInt32(4, i3);
            }
            float f = this.selectStartX_;
            if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(5, f);
            }
            float f2 = this.selectStartY_;
            if (f2 != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(6, f2);
            }
            float f3 = this.selectEndX_;
            if (f3 != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(7, f3);
            }
            float f4 = this.selectEndY_;
            if (f4 != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(8, f4);
            }
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.selectShape_.size(); i3++) {
                i2 += CodedOutputStream.computeInt32SizeNoTag(this.selectShape_.getInt(i3));
            }
            int size = 0 + i2 + (getSelectShapeList().size() * 1);
            int i4 = this.selectLineWidth_;
            if (i4 != 0) {
                size += CodedOutputStream.computeUInt32Size(2, i4);
            }
            if (!this.selectLineColor_.isEmpty()) {
                size += CodedOutputStream.computeStringSize(3, getSelectLineColor());
            }
            int i5 = this.selectLineType_;
            if (i5 != 0) {
                size += CodedOutputStream.computeUInt32Size(4, i5);
            }
            float f = this.selectStartX_;
            if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
                size += CodedOutputStream.computeFloatSize(5, f);
            }
            float f2 = this.selectStartY_;
            if (f2 != CropImageView.DEFAULT_ASPECT_RATIO) {
                size += CodedOutputStream.computeFloatSize(6, f2);
            }
            float f3 = this.selectEndX_;
            if (f3 != CropImageView.DEFAULT_ASPECT_RATIO) {
                size += CodedOutputStream.computeFloatSize(7, f3);
            }
            float f4 = this.selectEndY_;
            if (f4 != CropImageView.DEFAULT_ASPECT_RATIO) {
                size += CodedOutputStream.computeFloatSize(8, f4);
            }
            this.memoizedSerializedSize = size;
            return size;
        }

        public static WXWBChooseConfig parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static WXWBChooseConfig parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static WXWBChooseConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static WXWBChooseConfig parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static WXWBChooseConfig parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WXWBChooseConfig parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WXWBChooseConfig parseDelimitedFrom(InputStream inputStream) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WXWBChooseConfig parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WXWBChooseConfig parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static WXWBChooseConfig parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WXWBChooseConfig wXWBChooseConfig) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(wXWBChooseConfig);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<WXWBChooseConfig, Builder> implements WXWBChooseConfigOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(WXWBChooseConfig.DEFAULT_INSTANCE);
            }

            public List<Integer> getSelectShapeList() {
                return Collections.unmodifiableList(this.instance.getSelectShapeList());
            }

            public int getSelectShapeCount() {
                return this.instance.getSelectShapeCount();
            }

            public int getSelectShape(int i) {
                return this.instance.getSelectShape(i);
            }

            public Builder setSelectShape(int i, int i2) {
                copyOnWrite();
                this.instance.setSelectShape(i, i2);
                return this;
            }

            public Builder addSelectShape(int i) {
                copyOnWrite();
                this.instance.addSelectShape(i);
                return this;
            }

            public Builder addAllSelectShape(Iterable<? extends Integer> iterable) {
                copyOnWrite();
                this.instance.addAllSelectShape(iterable);
                return this;
            }

            public Builder clearSelectShape() {
                copyOnWrite();
                this.instance.clearSelectShape();
                return this;
            }

            public int getSelectLineWidth() {
                return this.instance.getSelectLineWidth();
            }

            public Builder setSelectLineWidth(int i) {
                copyOnWrite();
                this.instance.setSelectLineWidth(i);
                return this;
            }

            public Builder clearSelectLineWidth() {
                copyOnWrite();
                this.instance.clearSelectLineWidth();
                return this;
            }

            public String getSelectLineColor() {
                return this.instance.getSelectLineColor();
            }

            public ByteString getSelectLineColorBytes() {
                return this.instance.getSelectLineColorBytes();
            }

            public Builder setSelectLineColor(String str) {
                copyOnWrite();
                this.instance.setSelectLineColor(str);
                return this;
            }

            public Builder clearSelectLineColor() {
                copyOnWrite();
                this.instance.clearSelectLineColor();
                return this;
            }

            public Builder setSelectLineColorBytes(ByteString byteString) {
                copyOnWrite();
                this.instance.setSelectLineColorBytes(byteString);
                return this;
            }

            public int getSelectLineType() {
                return this.instance.getSelectLineType();
            }

            public Builder setSelectLineType(int i) {
                copyOnWrite();
                this.instance.setSelectLineType(i);
                return this;
            }

            public Builder clearSelectLineType() {
                copyOnWrite();
                this.instance.clearSelectLineType();
                return this;
            }

            public float getSelectStartX() {
                return this.instance.getSelectStartX();
            }

            public Builder setSelectStartX(float f) {
                copyOnWrite();
                this.instance.setSelectStartX(f);
                return this;
            }

            public Builder clearSelectStartX() {
                copyOnWrite();
                this.instance.clearSelectStartX();
                return this;
            }

            public float getSelectStartY() {
                return this.instance.getSelectStartY();
            }

            public Builder setSelectStartY(float f) {
                copyOnWrite();
                this.instance.setSelectStartY(f);
                return this;
            }

            public Builder clearSelectStartY() {
                copyOnWrite();
                this.instance.clearSelectStartY();
                return this;
            }

            public float getSelectEndX() {
                return this.instance.getSelectEndX();
            }

            public Builder setSelectEndX(float f) {
                copyOnWrite();
                this.instance.setSelectEndX(f);
                return this;
            }

            public Builder clearSelectEndX() {
                copyOnWrite();
                this.instance.clearSelectEndX();
                return this;
            }

            public float getSelectEndY() {
                return this.instance.getSelectEndY();
            }

            public Builder setSelectEndY(float f) {
                copyOnWrite();
                this.instance.setSelectEndY(f);
                return this;
            }

            public Builder clearSelectEndY() {
                copyOnWrite();
                this.instance.clearSelectEndY();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new WXWBChooseConfig();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.selectShape_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = (GeneratedMessageLite.Visitor) obj;
                    WXWBChooseConfig wXWBChooseConfig = (WXWBChooseConfig) obj2;
                    this.selectShape_ = mergeFromVisitor.visitIntList(this.selectShape_, wXWBChooseConfig.selectShape_);
                    int i = this.selectLineWidth_;
                    boolean z2 = i != 0;
                    int i2 = wXWBChooseConfig.selectLineWidth_;
                    this.selectLineWidth_ = mergeFromVisitor.visitInt(z2, i, i2 != 0, i2);
                    this.selectLineColor_ = mergeFromVisitor.visitString(!this.selectLineColor_.isEmpty(), this.selectLineColor_, !wXWBChooseConfig.selectLineColor_.isEmpty(), wXWBChooseConfig.selectLineColor_);
                    int i3 = this.selectLineType_;
                    boolean z3 = i3 != 0;
                    int i4 = wXWBChooseConfig.selectLineType_;
                    this.selectLineType_ = mergeFromVisitor.visitInt(z3, i3, i4 != 0, i4);
                    float f = this.selectStartX_;
                    boolean z4 = f != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f2 = wXWBChooseConfig.selectStartX_;
                    this.selectStartX_ = mergeFromVisitor.visitFloat(z4, f, f2 != CropImageView.DEFAULT_ASPECT_RATIO, f2);
                    float f3 = this.selectStartY_;
                    boolean z5 = f3 != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f4 = wXWBChooseConfig.selectStartY_;
                    this.selectStartY_ = mergeFromVisitor.visitFloat(z5, f3, f4 != CropImageView.DEFAULT_ASPECT_RATIO, f4);
                    float f5 = this.selectEndX_;
                    boolean z6 = f5 != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f6 = wXWBChooseConfig.selectEndX_;
                    this.selectEndX_ = mergeFromVisitor.visitFloat(z6, f5, f6 != CropImageView.DEFAULT_ASPECT_RATIO, f6);
                    float f7 = this.selectEndY_;
                    boolean z7 = f7 != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f8 = wXWBChooseConfig.selectEndY_;
                    if (f8 != CropImageView.DEFAULT_ASPECT_RATIO) {
                        z = true;
                    }
                    this.selectEndY_ = mergeFromVisitor.visitFloat(z7, f7, z, f8);
                    if (mergeFromVisitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= wXWBChooseConfig.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    if (!this.selectShape_.isModifiable()) {
                                        this.selectShape_ = GeneratedMessageLite.mutableCopy(this.selectShape_);
                                    }
                                    this.selectShape_.addInt(codedInputStream.readInt32());
                                } else if (readTag == 10) {
                                    int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if (!this.selectShape_.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.selectShape_ = GeneratedMessageLite.mutableCopy(this.selectShape_);
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.selectShape_.addInt(codedInputStream.readInt32());
                                    }
                                    codedInputStream.popLimit(pushLimit);
                                } else if (readTag == 16) {
                                    this.selectLineWidth_ = codedInputStream.readUInt32();
                                } else if (readTag == 26) {
                                    this.selectLineColor_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 32) {
                                    this.selectLineType_ = codedInputStream.readUInt32();
                                } else if (readTag == 45) {
                                    this.selectStartX_ = codedInputStream.readFloat();
                                } else if (readTag == 53) {
                                    this.selectStartY_ = codedInputStream.readFloat();
                                } else if (readTag == 61) {
                                    this.selectEndX_ = codedInputStream.readFloat();
                                } else if (readTag == 69) {
                                    this.selectEndY_ = codedInputStream.readFloat();
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (WXWBChooseConfig.class) {
                            if (PARSER == null) {
                                PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }
                    return PARSER;
                default:
                    throw new UnsupportedOperationException();
            }
            return DEFAULT_INSTANCE;
        }

        static {
            WXWBChooseConfig wXWBChooseConfig = new WXWBChooseConfig();
            DEFAULT_INSTANCE = wXWBChooseConfig;
            wXWBChooseConfig.makeImmutable();
        }

        public static WXWBChooseConfig getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WXWBChooseConfig> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class WXWBRevokeAndRecoverConfig extends GeneratedMessageLite<WXWBRevokeAndRecoverConfig, Builder> implements WXWBRevokeAndRecoverConfigOrBuilder {
        public static final int ACTIONLIST_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final WXWBRevokeAndRecoverConfig DEFAULT_INSTANCE;
        public static final int HISTORY_INDEX_FIELD_NUMBER = 2;
        public static final int IS_REVERSE_FIELD_NUMBER = 3;
        private static volatile Parser<WXWBRevokeAndRecoverConfig> PARSER;
        private Internal.ProtobufList<String> actionList_ = GeneratedMessageLite.emptyProtobufList();
        private int bitField0_;
        private int historyIndex_;
        private int isReverse_;

        private WXWBRevokeAndRecoverConfig() {
        }

        public List<String> getActionListList() {
            return this.actionList_;
        }

        public int getActionListCount() {
            return this.actionList_.size();
        }

        public String getActionList(int i) {
            return (String) this.actionList_.get(i);
        }

        public ByteString getActionListBytes(int i) {
            return ByteString.copyFromUtf8((String) this.actionList_.get(i));
        }

        private void ensureActionListIsMutable() {
            if (!this.actionList_.isModifiable()) {
                this.actionList_ = GeneratedMessageLite.mutableCopy(this.actionList_);
            }
        }

        /* access modifiers changed from: private */
        public void setActionList(int i, String str) {
            Objects.requireNonNull(str);
            ensureActionListIsMutable();
            this.actionList_.set(i, str);
        }

        /* access modifiers changed from: private */
        public void addActionList(String str) {
            Objects.requireNonNull(str);
            ensureActionListIsMutable();
            this.actionList_.add(str);
        }

        /* access modifiers changed from: private */
        public void addAllActionList(Iterable<String> iterable) {
            ensureActionListIsMutable();
            AbstractMessageLite.addAll(iterable, this.actionList_);
        }

        /* access modifiers changed from: private */
        public void clearActionList() {
            this.actionList_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void addActionListBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            checkByteStringIsUtf8(byteString);
            ensureActionListIsMutable();
            this.actionList_.add(byteString.toStringUtf8());
        }

        public int getHistoryIndex() {
            return this.historyIndex_;
        }

        /* access modifiers changed from: private */
        public void setHistoryIndex(int i) {
            this.historyIndex_ = i;
        }

        /* access modifiers changed from: private */
        public void clearHistoryIndex() {
            this.historyIndex_ = 0;
        }

        public int getIsReverse() {
            return this.isReverse_;
        }

        /* access modifiers changed from: private */
        public void setIsReverse(int i) {
            this.isReverse_ = i;
        }

        /* access modifiers changed from: private */
        public void clearIsReverse() {
            this.isReverse_ = 0;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            for (int i = 0; i < this.actionList_.size(); i++) {
                codedOutputStream.writeString(1, (String) this.actionList_.get(i));
            }
            int i2 = this.historyIndex_;
            if (i2 != 0) {
                codedOutputStream.writeUInt32(2, i2);
            }
            int i3 = this.isReverse_;
            if (i3 != 0) {
                codedOutputStream.writeUInt32(3, i3);
            }
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.actionList_.size(); i3++) {
                i2 += CodedOutputStream.computeStringSizeNoTag((String) this.actionList_.get(i3));
            }
            int size = 0 + i2 + (getActionListList().size() * 1);
            int i4 = this.historyIndex_;
            if (i4 != 0) {
                size += CodedOutputStream.computeUInt32Size(2, i4);
            }
            int i5 = this.isReverse_;
            if (i5 != 0) {
                size += CodedOutputStream.computeUInt32Size(3, i5);
            }
            this.memoizedSerializedSize = size;
            return size;
        }

        public static WXWBRevokeAndRecoverConfig parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static WXWBRevokeAndRecoverConfig parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static WXWBRevokeAndRecoverConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static WXWBRevokeAndRecoverConfig parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static WXWBRevokeAndRecoverConfig parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WXWBRevokeAndRecoverConfig parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WXWBRevokeAndRecoverConfig parseDelimitedFrom(InputStream inputStream) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WXWBRevokeAndRecoverConfig parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WXWBRevokeAndRecoverConfig parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static WXWBRevokeAndRecoverConfig parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WXWBRevokeAndRecoverConfig wXWBRevokeAndRecoverConfig) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(wXWBRevokeAndRecoverConfig);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<WXWBRevokeAndRecoverConfig, Builder> implements WXWBRevokeAndRecoverConfigOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(WXWBRevokeAndRecoverConfig.DEFAULT_INSTANCE);
            }

            public List<String> getActionListList() {
                return Collections.unmodifiableList(this.instance.getActionListList());
            }

            public int getActionListCount() {
                return this.instance.getActionListCount();
            }

            public String getActionList(int i) {
                return this.instance.getActionList(i);
            }

            public ByteString getActionListBytes(int i) {
                return this.instance.getActionListBytes(i);
            }

            public Builder setActionList(int i, String str) {
                copyOnWrite();
                this.instance.setActionList(i, str);
                return this;
            }

            public Builder addActionList(String str) {
                copyOnWrite();
                this.instance.addActionList(str);
                return this;
            }

            public Builder addAllActionList(Iterable<String> iterable) {
                copyOnWrite();
                this.instance.addAllActionList(iterable);
                return this;
            }

            public Builder clearActionList() {
                copyOnWrite();
                this.instance.clearActionList();
                return this;
            }

            public Builder addActionListBytes(ByteString byteString) {
                copyOnWrite();
                this.instance.addActionListBytes(byteString);
                return this;
            }

            public int getHistoryIndex() {
                return this.instance.getHistoryIndex();
            }

            public Builder setHistoryIndex(int i) {
                copyOnWrite();
                this.instance.setHistoryIndex(i);
                return this;
            }

            public Builder clearHistoryIndex() {
                copyOnWrite();
                this.instance.clearHistoryIndex();
                return this;
            }

            public int getIsReverse() {
                return this.instance.getIsReverse();
            }

            public Builder setIsReverse(int i) {
                copyOnWrite();
                this.instance.setIsReverse(i);
                return this;
            }

            public Builder clearIsReverse() {
                copyOnWrite();
                this.instance.clearIsReverse();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new WXWBRevokeAndRecoverConfig();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.actionList_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = (GeneratedMessageLite.Visitor) obj;
                    WXWBRevokeAndRecoverConfig wXWBRevokeAndRecoverConfig = (WXWBRevokeAndRecoverConfig) obj2;
                    this.actionList_ = mergeFromVisitor.visitList(this.actionList_, wXWBRevokeAndRecoverConfig.actionList_);
                    int i = this.historyIndex_;
                    boolean z2 = i != 0;
                    int i2 = wXWBRevokeAndRecoverConfig.historyIndex_;
                    this.historyIndex_ = mergeFromVisitor.visitInt(z2, i, i2 != 0, i2);
                    int i3 = this.isReverse_;
                    boolean z3 = i3 != 0;
                    int i4 = wXWBRevokeAndRecoverConfig.isReverse_;
                    if (i4 != 0) {
                        z = true;
                    }
                    this.isReverse_ = mergeFromVisitor.visitInt(z3, i3, z, i4);
                    if (mergeFromVisitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= wXWBRevokeAndRecoverConfig.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    String readStringRequireUtf8 = codedInputStream.readStringRequireUtf8();
                                    if (!this.actionList_.isModifiable()) {
                                        this.actionList_ = GeneratedMessageLite.mutableCopy(this.actionList_);
                                    }
                                    this.actionList_.add(readStringRequireUtf8);
                                } else if (readTag == 16) {
                                    this.historyIndex_ = codedInputStream.readUInt32();
                                } else if (readTag == 24) {
                                    this.isReverse_ = codedInputStream.readUInt32();
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (WXWBRevokeAndRecoverConfig.class) {
                            if (PARSER == null) {
                                PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }
                    return PARSER;
                default:
                    throw new UnsupportedOperationException();
            }
            return DEFAULT_INSTANCE;
        }

        static {
            WXWBRevokeAndRecoverConfig wXWBRevokeAndRecoverConfig = new WXWBRevokeAndRecoverConfig();
            DEFAULT_INSTANCE = wXWBRevokeAndRecoverConfig;
            wXWBRevokeAndRecoverConfig.makeImmutable();
        }

        public static WXWBRevokeAndRecoverConfig getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WXWBRevokeAndRecoverConfig> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class WXWBPoint extends GeneratedMessageLite<WXWBPoint, Builder> implements WXWBPointOrBuilder {
        public static final int ACTION_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final WXWBPoint DEFAULT_INSTANCE;
        public static final int ERASE_FIELD_NUMBER = 10;
        public static final int LINEWIDTH_FIELD_NUMBER = 4;
        private static volatile Parser<WXWBPoint> PARSER = null;
        public static final int X_FIELD_NUMBER = 2;
        public static final int Y_FIELD_NUMBER = 3;
        private int action_;
        private String erase_ = "";
        private float lineWidth_;
        private float x_;
        private float y_;

        private WXWBPoint() {
        }

        public int getActionValue() {
            return this.action_;
        }

        public WXWBPointAction getAction() {
            WXWBPointAction forNumber = WXWBPointAction.forNumber(this.action_);
            return forNumber == null ? WXWBPointAction.UNRECOGNIZED : forNumber;
        }

        /* access modifiers changed from: private */
        public void setActionValue(int i) {
            this.action_ = i;
        }

        /* access modifiers changed from: private */
        public void setAction(WXWBPointAction wXWBPointAction) {
            Objects.requireNonNull(wXWBPointAction);
            this.action_ = wXWBPointAction.getNumber();
        }

        /* access modifiers changed from: private */
        public void clearAction() {
            this.action_ = 0;
        }

        public float getX() {
            return this.x_;
        }

        /* access modifiers changed from: private */
        public void setX(float f) {
            this.x_ = f;
        }

        /* access modifiers changed from: private */
        public void clearX() {
            this.x_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public float getY() {
            return this.y_;
        }

        /* access modifiers changed from: private */
        public void setY(float f) {
            this.y_ = f;
        }

        /* access modifiers changed from: private */
        public void clearY() {
            this.y_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public float getLineWidth() {
            return this.lineWidth_;
        }

        /* access modifiers changed from: private */
        public void setLineWidth(float f) {
            this.lineWidth_ = f;
        }

        /* access modifiers changed from: private */
        public void clearLineWidth() {
            this.lineWidth_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public String getErase() {
            return this.erase_;
        }

        public ByteString getEraseBytes() {
            return ByteString.copyFromUtf8(this.erase_);
        }

        /* access modifiers changed from: private */
        public void setErase(String str) {
            Objects.requireNonNull(str);
            this.erase_ = str;
        }

        /* access modifiers changed from: private */
        public void clearErase() {
            this.erase_ = getDefaultInstance().getErase();
        }

        /* access modifiers changed from: private */
        public void setEraseBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            checkByteStringIsUtf8(byteString);
            this.erase_ = byteString.toStringUtf8();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.action_ != WXWBPointAction.WXWBPointActionStart.getNumber()) {
                codedOutputStream.writeEnum(1, this.action_);
            }
            float f = this.x_;
            if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(2, f);
            }
            float f2 = this.y_;
            if (f2 != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(3, f2);
            }
            float f3 = this.lineWidth_;
            if (f3 != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(4, f3);
            }
            if (!this.erase_.isEmpty()) {
                codedOutputStream.writeString(10, getErase());
            }
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (this.action_ != WXWBPointAction.WXWBPointActionStart.getNumber()) {
                i2 = 0 + CodedOutputStream.computeEnumSize(1, this.action_);
            }
            float f = this.x_;
            if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += CodedOutputStream.computeFloatSize(2, f);
            }
            float f2 = this.y_;
            if (f2 != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += CodedOutputStream.computeFloatSize(3, f2);
            }
            float f3 = this.lineWidth_;
            if (f3 != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += CodedOutputStream.computeFloatSize(4, f3);
            }
            if (!this.erase_.isEmpty()) {
                i2 += CodedOutputStream.computeStringSize(10, getErase());
            }
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public static WXWBPoint parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static WXWBPoint parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static WXWBPoint parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static WXWBPoint parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static WXWBPoint parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WXWBPoint parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WXWBPoint parseDelimitedFrom(InputStream inputStream) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WXWBPoint parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WXWBPoint parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static WXWBPoint parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WXWBPoint wXWBPoint) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(wXWBPoint);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<WXWBPoint, Builder> implements WXWBPointOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(WXWBPoint.DEFAULT_INSTANCE);
            }

            public int getActionValue() {
                return this.instance.getActionValue();
            }

            public Builder setActionValue(int i) {
                copyOnWrite();
                this.instance.setActionValue(i);
                return this;
            }

            public WXWBPointAction getAction() {
                return this.instance.getAction();
            }

            public Builder setAction(WXWBPointAction wXWBPointAction) {
                copyOnWrite();
                this.instance.setAction(wXWBPointAction);
                return this;
            }

            public Builder clearAction() {
                copyOnWrite();
                this.instance.clearAction();
                return this;
            }

            public float getX() {
                return this.instance.getX();
            }

            public Builder setX(float f) {
                copyOnWrite();
                this.instance.setX(f);
                return this;
            }

            public Builder clearX() {
                copyOnWrite();
                this.instance.clearX();
                return this;
            }

            public float getY() {
                return this.instance.getY();
            }

            public Builder setY(float f) {
                copyOnWrite();
                this.instance.setY(f);
                return this;
            }

            public Builder clearY() {
                copyOnWrite();
                this.instance.clearY();
                return this;
            }

            public float getLineWidth() {
                return this.instance.getLineWidth();
            }

            public Builder setLineWidth(float f) {
                copyOnWrite();
                this.instance.setLineWidth(f);
                return this;
            }

            public Builder clearLineWidth() {
                copyOnWrite();
                this.instance.clearLineWidth();
                return this;
            }

            public String getErase() {
                return this.instance.getErase();
            }

            public ByteString getEraseBytes() {
                return this.instance.getEraseBytes();
            }

            public Builder setErase(String str) {
                copyOnWrite();
                this.instance.setErase(str);
                return this;
            }

            public Builder clearErase() {
                copyOnWrite();
                this.instance.clearErase();
                return this;
            }

            public Builder setEraseBytes(ByteString byteString) {
                copyOnWrite();
                this.instance.setEraseBytes(byteString);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new WXWBPoint();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    WXWBPoint wXWBPoint = (WXWBPoint) obj2;
                    int i = this.action_;
                    boolean z2 = i != 0;
                    int i2 = wXWBPoint.action_;
                    this.action_ = visitor.visitInt(z2, i, i2 != 0, i2);
                    float f = this.x_;
                    boolean z3 = f != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f2 = wXWBPoint.x_;
                    this.x_ = visitor.visitFloat(z3, f, f2 != CropImageView.DEFAULT_ASPECT_RATIO, f2);
                    float f3 = this.y_;
                    boolean z4 = f3 != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f4 = wXWBPoint.y_;
                    this.y_ = visitor.visitFloat(z4, f3, f4 != CropImageView.DEFAULT_ASPECT_RATIO, f4);
                    float f5 = this.lineWidth_;
                    boolean z5 = f5 != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f6 = wXWBPoint.lineWidth_;
                    if (f6 != CropImageView.DEFAULT_ASPECT_RATIO) {
                        z = true;
                    }
                    this.lineWidth_ = visitor.visitFloat(z5, f5, z, f6);
                    this.erase_ = visitor.visitString(!this.erase_.isEmpty(), this.erase_, !wXWBPoint.erase_.isEmpty(), wXWBPoint.erase_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.action_ = codedInputStream.readEnum();
                                } else if (readTag == 21) {
                                    this.x_ = codedInputStream.readFloat();
                                } else if (readTag == 29) {
                                    this.y_ = codedInputStream.readFloat();
                                } else if (readTag == 37) {
                                    this.lineWidth_ = codedInputStream.readFloat();
                                } else if (readTag == 82) {
                                    this.erase_ = codedInputStream.readStringRequireUtf8();
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (WXWBPoint.class) {
                            if (PARSER == null) {
                                PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }
                    return PARSER;
                default:
                    throw new UnsupportedOperationException();
            }
            return DEFAULT_INSTANCE;
        }

        static {
            WXWBPoint wXWBPoint = new WXWBPoint();
            DEFAULT_INSTANCE = wXWBPoint;
            wXWBPoint.makeImmutable();
        }

        public static WXWBPoint getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WXWBPoint> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class WXWBOffset extends GeneratedMessageLite<WXWBOffset, Builder> implements WXWBOffsetOrBuilder {
        /* access modifiers changed from: private */
        public static final WXWBOffset DEFAULT_INSTANCE;
        public static final int OFFSETX_FIELD_NUMBER = 1;
        public static final int OFFSETY_FIELD_NUMBER = 2;
        private static volatile Parser<WXWBOffset> PARSER;
        private float offsetX_;
        private float offsetY_;

        private WXWBOffset() {
        }

        public float getOffsetX() {
            return this.offsetX_;
        }

        /* access modifiers changed from: private */
        public void setOffsetX(float f) {
            this.offsetX_ = f;
        }

        /* access modifiers changed from: private */
        public void clearOffsetX() {
            this.offsetX_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public float getOffsetY() {
            return this.offsetY_;
        }

        /* access modifiers changed from: private */
        public void setOffsetY(float f) {
            this.offsetY_ = f;
        }

        /* access modifiers changed from: private */
        public void clearOffsetY() {
            this.offsetY_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            float f = this.offsetX_;
            if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(1, f);
            }
            float f2 = this.offsetY_;
            if (f2 != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(2, f2);
            }
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            float f = this.offsetX_;
            if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 = 0 + CodedOutputStream.computeFloatSize(1, f);
            }
            float f2 = this.offsetY_;
            if (f2 != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += CodedOutputStream.computeFloatSize(2, f2);
            }
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public static WXWBOffset parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static WXWBOffset parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static WXWBOffset parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static WXWBOffset parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static WXWBOffset parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WXWBOffset parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WXWBOffset parseDelimitedFrom(InputStream inputStream) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WXWBOffset parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WXWBOffset parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static WXWBOffset parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WXWBOffset wXWBOffset) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(wXWBOffset);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<WXWBOffset, Builder> implements WXWBOffsetOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(WXWBOffset.DEFAULT_INSTANCE);
            }

            public float getOffsetX() {
                return this.instance.getOffsetX();
            }

            public Builder setOffsetX(float f) {
                copyOnWrite();
                this.instance.setOffsetX(f);
                return this;
            }

            public Builder clearOffsetX() {
                copyOnWrite();
                this.instance.clearOffsetX();
                return this;
            }

            public float getOffsetY() {
                return this.instance.getOffsetY();
            }

            public Builder setOffsetY(float f) {
                copyOnWrite();
                this.instance.setOffsetY(f);
                return this;
            }

            public Builder clearOffsetY() {
                copyOnWrite();
                this.instance.clearOffsetY();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new WXWBOffset();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    WXWBOffset wXWBOffset = (WXWBOffset) obj2;
                    float f = this.offsetX_;
                    boolean z2 = f != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f2 = wXWBOffset.offsetX_;
                    this.offsetX_ = visitor.visitFloat(z2, f, f2 != CropImageView.DEFAULT_ASPECT_RATIO, f2);
                    float f3 = this.offsetY_;
                    boolean z3 = f3 != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f4 = wXWBOffset.offsetY_;
                    if (f4 != CropImageView.DEFAULT_ASPECT_RATIO) {
                        z = true;
                    }
                    this.offsetY_ = visitor.visitFloat(z3, f3, z, f4);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 13) {
                                    this.offsetX_ = codedInputStream.readFloat();
                                } else if (readTag == 21) {
                                    this.offsetY_ = codedInputStream.readFloat();
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (WXWBOffset.class) {
                            if (PARSER == null) {
                                PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }
                    return PARSER;
                default:
                    throw new UnsupportedOperationException();
            }
            return DEFAULT_INSTANCE;
        }

        static {
            WXWBOffset wXWBOffset = new WXWBOffset();
            DEFAULT_INSTANCE = wXWBOffset;
            wXWBOffset.makeImmutable();
        }

        public static WXWBOffset getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WXWBOffset> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class WXWBChooseShapeOffset extends GeneratedMessageLite<WXWBChooseShapeOffset, Builder> implements WXWBChooseShapeOffsetOrBuilder {
        /* access modifiers changed from: private */
        public static final WXWBChooseShapeOffset DEFAULT_INSTANCE;
        public static final int ENDOFFSETX_FIELD_NUMBER = 3;
        public static final int ENDOFFSETY_FIELD_NUMBER = 4;
        private static volatile Parser<WXWBChooseShapeOffset> PARSER = null;
        public static final int STARTOFFSETX_FIELD_NUMBER = 1;
        public static final int STARTOFFSETY_FIELD_NUMBER = 2;
        private float endOffsetX_;
        private float endOffsetY_;
        private float startOffsetX_;
        private float startOffsetY_;

        private WXWBChooseShapeOffset() {
        }

        public float getStartOffsetX() {
            return this.startOffsetX_;
        }

        /* access modifiers changed from: private */
        public void setStartOffsetX(float f) {
            this.startOffsetX_ = f;
        }

        /* access modifiers changed from: private */
        public void clearStartOffsetX() {
            this.startOffsetX_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public float getStartOffsetY() {
            return this.startOffsetY_;
        }

        /* access modifiers changed from: private */
        public void setStartOffsetY(float f) {
            this.startOffsetY_ = f;
        }

        /* access modifiers changed from: private */
        public void clearStartOffsetY() {
            this.startOffsetY_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public float getEndOffsetX() {
            return this.endOffsetX_;
        }

        /* access modifiers changed from: private */
        public void setEndOffsetX(float f) {
            this.endOffsetX_ = f;
        }

        /* access modifiers changed from: private */
        public void clearEndOffsetX() {
            this.endOffsetX_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public float getEndOffsetY() {
            return this.endOffsetY_;
        }

        /* access modifiers changed from: private */
        public void setEndOffsetY(float f) {
            this.endOffsetY_ = f;
        }

        /* access modifiers changed from: private */
        public void clearEndOffsetY() {
            this.endOffsetY_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            float f = this.startOffsetX_;
            if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(1, f);
            }
            float f2 = this.startOffsetY_;
            if (f2 != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(2, f2);
            }
            float f3 = this.endOffsetX_;
            if (f3 != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(3, f3);
            }
            float f4 = this.endOffsetY_;
            if (f4 != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(4, f4);
            }
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            float f = this.startOffsetX_;
            if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 = 0 + CodedOutputStream.computeFloatSize(1, f);
            }
            float f2 = this.startOffsetY_;
            if (f2 != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += CodedOutputStream.computeFloatSize(2, f2);
            }
            float f3 = this.endOffsetX_;
            if (f3 != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += CodedOutputStream.computeFloatSize(3, f3);
            }
            float f4 = this.endOffsetY_;
            if (f4 != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += CodedOutputStream.computeFloatSize(4, f4);
            }
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public static WXWBChooseShapeOffset parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static WXWBChooseShapeOffset parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static WXWBChooseShapeOffset parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static WXWBChooseShapeOffset parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static WXWBChooseShapeOffset parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WXWBChooseShapeOffset parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WXWBChooseShapeOffset parseDelimitedFrom(InputStream inputStream) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WXWBChooseShapeOffset parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WXWBChooseShapeOffset parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static WXWBChooseShapeOffset parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WXWBChooseShapeOffset wXWBChooseShapeOffset) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(wXWBChooseShapeOffset);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<WXWBChooseShapeOffset, Builder> implements WXWBChooseShapeOffsetOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(WXWBChooseShapeOffset.DEFAULT_INSTANCE);
            }

            public float getStartOffsetX() {
                return this.instance.getStartOffsetX();
            }

            public Builder setStartOffsetX(float f) {
                copyOnWrite();
                this.instance.setStartOffsetX(f);
                return this;
            }

            public Builder clearStartOffsetX() {
                copyOnWrite();
                this.instance.clearStartOffsetX();
                return this;
            }

            public float getStartOffsetY() {
                return this.instance.getStartOffsetY();
            }

            public Builder setStartOffsetY(float f) {
                copyOnWrite();
                this.instance.setStartOffsetY(f);
                return this;
            }

            public Builder clearStartOffsetY() {
                copyOnWrite();
                this.instance.clearStartOffsetY();
                return this;
            }

            public float getEndOffsetX() {
                return this.instance.getEndOffsetX();
            }

            public Builder setEndOffsetX(float f) {
                copyOnWrite();
                this.instance.setEndOffsetX(f);
                return this;
            }

            public Builder clearEndOffsetX() {
                copyOnWrite();
                this.instance.clearEndOffsetX();
                return this;
            }

            public float getEndOffsetY() {
                return this.instance.getEndOffsetY();
            }

            public Builder setEndOffsetY(float f) {
                copyOnWrite();
                this.instance.setEndOffsetY(f);
                return this;
            }

            public Builder clearEndOffsetY() {
                copyOnWrite();
                this.instance.clearEndOffsetY();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new WXWBChooseShapeOffset();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    WXWBChooseShapeOffset wXWBChooseShapeOffset = (WXWBChooseShapeOffset) obj2;
                    float f = this.startOffsetX_;
                    boolean z2 = f != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f2 = wXWBChooseShapeOffset.startOffsetX_;
                    this.startOffsetX_ = visitor.visitFloat(z2, f, f2 != CropImageView.DEFAULT_ASPECT_RATIO, f2);
                    float f3 = this.startOffsetY_;
                    boolean z3 = f3 != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f4 = wXWBChooseShapeOffset.startOffsetY_;
                    this.startOffsetY_ = visitor.visitFloat(z3, f3, f4 != CropImageView.DEFAULT_ASPECT_RATIO, f4);
                    float f5 = this.endOffsetX_;
                    boolean z4 = f5 != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f6 = wXWBChooseShapeOffset.endOffsetX_;
                    this.endOffsetX_ = visitor.visitFloat(z4, f5, f6 != CropImageView.DEFAULT_ASPECT_RATIO, f6);
                    float f7 = this.endOffsetY_;
                    boolean z5 = f7 != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f8 = wXWBChooseShapeOffset.endOffsetY_;
                    if (f8 != CropImageView.DEFAULT_ASPECT_RATIO) {
                        z = true;
                    }
                    this.endOffsetY_ = visitor.visitFloat(z5, f7, z, f8);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 13) {
                                    this.startOffsetX_ = codedInputStream.readFloat();
                                } else if (readTag == 21) {
                                    this.startOffsetY_ = codedInputStream.readFloat();
                                } else if (readTag == 29) {
                                    this.endOffsetX_ = codedInputStream.readFloat();
                                } else if (readTag == 37) {
                                    this.endOffsetY_ = codedInputStream.readFloat();
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (WXWBChooseShapeOffset.class) {
                            if (PARSER == null) {
                                PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }
                    return PARSER;
                default:
                    throw new UnsupportedOperationException();
            }
            return DEFAULT_INSTANCE;
        }

        static {
            WXWBChooseShapeOffset wXWBChooseShapeOffset = new WXWBChooseShapeOffset();
            DEFAULT_INSTANCE = wXWBChooseShapeOffset;
            wXWBChooseShapeOffset.makeImmutable();
        }

        public static WXWBChooseShapeOffset getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WXWBChooseShapeOffset> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class WXWBCanvasInfo extends GeneratedMessageLite<WXWBCanvasInfo, Builder> implements WXWBCanvasInfoOrBuilder {
        public static final int CANVASID_FIELD_NUMBER = 1;
        /* access modifiers changed from: private */
        public static final WXWBCanvasInfo DEFAULT_INSTANCE;
        public static final int FILLCOLOR_FIELD_NUMBER = 8;
        public static final int HEIGHT_FIELD_NUMBER = 5;
        public static final int LINEWIDTH_FIELD_NUMBER = 6;
        private static volatile Parser<WXWBCanvasInfo> PARSER = null;
        public static final int STROKECOLOR_FIELD_NUMBER = 7;
        public static final int WIDTH_FIELD_NUMBER = 4;
        public static final int X_FIELD_NUMBER = 2;
        public static final int Y_FIELD_NUMBER = 3;
        private int canvasId_;
        private int fillColor_;
        private float height_;
        private float lineWidth_;
        private int strokeColor_;
        private float width_;
        private float x_;
        private float y_;

        private WXWBCanvasInfo() {
        }

        public int getCanvasId() {
            return this.canvasId_;
        }

        /* access modifiers changed from: private */
        public void setCanvasId(int i) {
            this.canvasId_ = i;
        }

        /* access modifiers changed from: private */
        public void clearCanvasId() {
            this.canvasId_ = 0;
        }

        public float getX() {
            return this.x_;
        }

        /* access modifiers changed from: private */
        public void setX(float f) {
            this.x_ = f;
        }

        /* access modifiers changed from: private */
        public void clearX() {
            this.x_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public float getY() {
            return this.y_;
        }

        /* access modifiers changed from: private */
        public void setY(float f) {
            this.y_ = f;
        }

        /* access modifiers changed from: private */
        public void clearY() {
            this.y_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public float getWidth() {
            return this.width_;
        }

        /* access modifiers changed from: private */
        public void setWidth(float f) {
            this.width_ = f;
        }

        /* access modifiers changed from: private */
        public void clearWidth() {
            this.width_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public float getHeight() {
            return this.height_;
        }

        /* access modifiers changed from: private */
        public void setHeight(float f) {
            this.height_ = f;
        }

        /* access modifiers changed from: private */
        public void clearHeight() {
            this.height_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public float getLineWidth() {
            return this.lineWidth_;
        }

        /* access modifiers changed from: private */
        public void setLineWidth(float f) {
            this.lineWidth_ = f;
        }

        /* access modifiers changed from: private */
        public void clearLineWidth() {
            this.lineWidth_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public int getStrokeColor() {
            return this.strokeColor_;
        }

        /* access modifiers changed from: private */
        public void setStrokeColor(int i) {
            this.strokeColor_ = i;
        }

        /* access modifiers changed from: private */
        public void clearStrokeColor() {
            this.strokeColor_ = 0;
        }

        public int getFillColor() {
            return this.fillColor_;
        }

        /* access modifiers changed from: private */
        public void setFillColor(int i) {
            this.fillColor_ = i;
        }

        /* access modifiers changed from: private */
        public void clearFillColor() {
            this.fillColor_ = 0;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            int i = this.canvasId_;
            if (i != 0) {
                codedOutputStream.writeUInt32(1, i);
            }
            float f = this.x_;
            if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(2, f);
            }
            float f2 = this.y_;
            if (f2 != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(3, f2);
            }
            float f3 = this.width_;
            if (f3 != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(4, f3);
            }
            float f4 = this.height_;
            if (f4 != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(5, f4);
            }
            float f5 = this.lineWidth_;
            if (f5 != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(6, f5);
            }
            int i2 = this.strokeColor_;
            if (i2 != 0) {
                codedOutputStream.writeUInt32(7, i2);
            }
            int i3 = this.fillColor_;
            if (i3 != 0) {
                codedOutputStream.writeUInt32(8, i3);
            }
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            int i3 = this.canvasId_;
            if (i3 != 0) {
                i2 = 0 + CodedOutputStream.computeUInt32Size(1, i3);
            }
            float f = this.x_;
            if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += CodedOutputStream.computeFloatSize(2, f);
            }
            float f2 = this.y_;
            if (f2 != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += CodedOutputStream.computeFloatSize(3, f2);
            }
            float f3 = this.width_;
            if (f3 != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += CodedOutputStream.computeFloatSize(4, f3);
            }
            float f4 = this.height_;
            if (f4 != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += CodedOutputStream.computeFloatSize(5, f4);
            }
            float f5 = this.lineWidth_;
            if (f5 != CropImageView.DEFAULT_ASPECT_RATIO) {
                i2 += CodedOutputStream.computeFloatSize(6, f5);
            }
            int i4 = this.strokeColor_;
            if (i4 != 0) {
                i2 += CodedOutputStream.computeUInt32Size(7, i4);
            }
            int i5 = this.fillColor_;
            if (i5 != 0) {
                i2 += CodedOutputStream.computeUInt32Size(8, i5);
            }
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public static WXWBCanvasInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static WXWBCanvasInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static WXWBCanvasInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static WXWBCanvasInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static WXWBCanvasInfo parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WXWBCanvasInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WXWBCanvasInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WXWBCanvasInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WXWBCanvasInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static WXWBCanvasInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WXWBCanvasInfo wXWBCanvasInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(wXWBCanvasInfo);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<WXWBCanvasInfo, Builder> implements WXWBCanvasInfoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(WXWBCanvasInfo.DEFAULT_INSTANCE);
            }

            public int getCanvasId() {
                return this.instance.getCanvasId();
            }

            public Builder setCanvasId(int i) {
                copyOnWrite();
                this.instance.setCanvasId(i);
                return this;
            }

            public Builder clearCanvasId() {
                copyOnWrite();
                this.instance.clearCanvasId();
                return this;
            }

            public float getX() {
                return this.instance.getX();
            }

            public Builder setX(float f) {
                copyOnWrite();
                this.instance.setX(f);
                return this;
            }

            public Builder clearX() {
                copyOnWrite();
                this.instance.clearX();
                return this;
            }

            public float getY() {
                return this.instance.getY();
            }

            public Builder setY(float f) {
                copyOnWrite();
                this.instance.setY(f);
                return this;
            }

            public Builder clearY() {
                copyOnWrite();
                this.instance.clearY();
                return this;
            }

            public float getWidth() {
                return this.instance.getWidth();
            }

            public Builder setWidth(float f) {
                copyOnWrite();
                this.instance.setWidth(f);
                return this;
            }

            public Builder clearWidth() {
                copyOnWrite();
                this.instance.clearWidth();
                return this;
            }

            public float getHeight() {
                return this.instance.getHeight();
            }

            public Builder setHeight(float f) {
                copyOnWrite();
                this.instance.setHeight(f);
                return this;
            }

            public Builder clearHeight() {
                copyOnWrite();
                this.instance.clearHeight();
                return this;
            }

            public float getLineWidth() {
                return this.instance.getLineWidth();
            }

            public Builder setLineWidth(float f) {
                copyOnWrite();
                this.instance.setLineWidth(f);
                return this;
            }

            public Builder clearLineWidth() {
                copyOnWrite();
                this.instance.clearLineWidth();
                return this;
            }

            public int getStrokeColor() {
                return this.instance.getStrokeColor();
            }

            public Builder setStrokeColor(int i) {
                copyOnWrite();
                this.instance.setStrokeColor(i);
                return this;
            }

            public Builder clearStrokeColor() {
                copyOnWrite();
                this.instance.clearStrokeColor();
                return this;
            }

            public int getFillColor() {
                return this.instance.getFillColor();
            }

            public Builder setFillColor(int i) {
                copyOnWrite();
                this.instance.setFillColor(i);
                return this;
            }

            public Builder clearFillColor() {
                copyOnWrite();
                this.instance.clearFillColor();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new WXWBCanvasInfo();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    WXWBCanvasInfo wXWBCanvasInfo = (WXWBCanvasInfo) obj2;
                    int i = this.canvasId_;
                    boolean z2 = i != 0;
                    int i2 = wXWBCanvasInfo.canvasId_;
                    this.canvasId_ = visitor.visitInt(z2, i, i2 != 0, i2);
                    float f = this.x_;
                    boolean z3 = f != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f2 = wXWBCanvasInfo.x_;
                    this.x_ = visitor.visitFloat(z3, f, f2 != CropImageView.DEFAULT_ASPECT_RATIO, f2);
                    float f3 = this.y_;
                    boolean z4 = f3 != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f4 = wXWBCanvasInfo.y_;
                    this.y_ = visitor.visitFloat(z4, f3, f4 != CropImageView.DEFAULT_ASPECT_RATIO, f4);
                    float f5 = this.width_;
                    boolean z5 = f5 != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f6 = wXWBCanvasInfo.width_;
                    this.width_ = visitor.visitFloat(z5, f5, f6 != CropImageView.DEFAULT_ASPECT_RATIO, f6);
                    float f7 = this.height_;
                    boolean z6 = f7 != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f8 = wXWBCanvasInfo.height_;
                    this.height_ = visitor.visitFloat(z6, f7, f8 != CropImageView.DEFAULT_ASPECT_RATIO, f8);
                    float f9 = this.lineWidth_;
                    boolean z7 = f9 != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f10 = wXWBCanvasInfo.lineWidth_;
                    this.lineWidth_ = visitor.visitFloat(z7, f9, f10 != CropImageView.DEFAULT_ASPECT_RATIO, f10);
                    int i3 = this.strokeColor_;
                    boolean z8 = i3 != 0;
                    int i4 = wXWBCanvasInfo.strokeColor_;
                    this.strokeColor_ = visitor.visitInt(z8, i3, i4 != 0, i4);
                    int i5 = this.fillColor_;
                    boolean z9 = i5 != 0;
                    int i6 = wXWBCanvasInfo.fillColor_;
                    if (i6 != 0) {
                        z = true;
                    }
                    this.fillColor_ = visitor.visitInt(z9, i5, z, i6);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    this.canvasId_ = codedInputStream.readUInt32();
                                } else if (readTag == 21) {
                                    this.x_ = codedInputStream.readFloat();
                                } else if (readTag == 29) {
                                    this.y_ = codedInputStream.readFloat();
                                } else if (readTag == 37) {
                                    this.width_ = codedInputStream.readFloat();
                                } else if (readTag == 45) {
                                    this.height_ = codedInputStream.readFloat();
                                } else if (readTag == 53) {
                                    this.lineWidth_ = codedInputStream.readFloat();
                                } else if (readTag == 56) {
                                    this.strokeColor_ = codedInputStream.readUInt32();
                                } else if (readTag == 64) {
                                    this.fillColor_ = codedInputStream.readUInt32();
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (WXWBCanvasInfo.class) {
                            if (PARSER == null) {
                                PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }
                    return PARSER;
                default:
                    throw new UnsupportedOperationException();
            }
            return DEFAULT_INSTANCE;
        }

        static {
            WXWBCanvasInfo wXWBCanvasInfo = new WXWBCanvasInfo();
            DEFAULT_INSTANCE = wXWBCanvasInfo;
            wXWBCanvasInfo.makeImmutable();
        }

        public static WXWBCanvasInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WXWBCanvasInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class WXWBUserInfo extends GeneratedMessageLite<WXWBUserInfo, Builder> implements WXWBUserInfoOrBuilder {
        /* access modifiers changed from: private */
        public static final WXWBUserInfo DEFAULT_INSTANCE;
        private static volatile Parser<WXWBUserInfo> PARSER = null;
        public static final int UNAME_FIELD_NUMBER = 1;
        private String uname_ = "";

        private WXWBUserInfo() {
        }

        public String getUname() {
            return this.uname_;
        }

        public ByteString getUnameBytes() {
            return ByteString.copyFromUtf8(this.uname_);
        }

        /* access modifiers changed from: private */
        public void setUname(String str) {
            Objects.requireNonNull(str);
            this.uname_ = str;
        }

        /* access modifiers changed from: private */
        public void clearUname() {
            this.uname_ = getDefaultInstance().getUname();
        }

        /* access modifiers changed from: private */
        public void setUnameBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            checkByteStringIsUtf8(byteString);
            this.uname_ = byteString.toStringUtf8();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.uname_.isEmpty()) {
                codedOutputStream.writeString(1, getUname());
            }
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!this.uname_.isEmpty()) {
                i2 = 0 + CodedOutputStream.computeStringSize(1, getUname());
            }
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public static WXWBUserInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static WXWBUserInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static WXWBUserInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static WXWBUserInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static WXWBUserInfo parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WXWBUserInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WXWBUserInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WXWBUserInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WXWBUserInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static WXWBUserInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WXWBUserInfo wXWBUserInfo) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(wXWBUserInfo);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<WXWBUserInfo, Builder> implements WXWBUserInfoOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(WXWBUserInfo.DEFAULT_INSTANCE);
            }

            public String getUname() {
                return this.instance.getUname();
            }

            public ByteString getUnameBytes() {
                return this.instance.getUnameBytes();
            }

            public Builder setUname(String str) {
                copyOnWrite();
                this.instance.setUname(str);
                return this;
            }

            public Builder clearUname() {
                copyOnWrite();
                this.instance.clearUname();
                return this;
            }

            public Builder setUnameBytes(ByteString byteString) {
                copyOnWrite();
                this.instance.setUnameBytes(byteString);
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new WXWBUserInfo();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    WXWBUserInfo wXWBUserInfo = (WXWBUserInfo) obj2;
                    this.uname_ = ((GeneratedMessageLite.Visitor) obj).visitString(!this.uname_.isEmpty(), this.uname_, true ^ wXWBUserInfo.uname_.isEmpty(), wXWBUserInfo.uname_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    boolean z = false;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.uname_ = codedInputStream.readStringRequireUtf8();
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (WXWBUserInfo.class) {
                            if (PARSER == null) {
                                PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }
                    return PARSER;
                default:
                    throw new UnsupportedOperationException();
            }
            return DEFAULT_INSTANCE;
        }

        static {
            WXWBUserInfo wXWBUserInfo = new WXWBUserInfo();
            DEFAULT_INSTANCE = wXWBUserInfo;
            wXWBUserInfo.makeImmutable();
        }

        public static WXWBUserInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WXWBUserInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class WXWBRefConfig extends GeneratedMessageLite<WXWBRefConfig, Builder> implements WXWBRefConfigOrBuilder {
        public static final int COLOR_FIELD_NUMBER = 6;
        public static final int DEFAULTHEIGHT_FIELD_NUMBER = 11;
        public static final int DEFAULTWIDTH_FIELD_NUMBER = 10;
        /* access modifiers changed from: private */
        public static final WXWBRefConfig DEFAULT_INSTANCE;
        public static final int FONTFAMILY_FIELD_NUMBER = 5;
        public static final int FONTSIZE_FIELD_NUMBER = 4;
        public static final int IMGURL_FIELD_NUMBER = 2;
        public static final int LINEHEIGHT_FIELD_NUMBER = 7;
        private static volatile Parser<WXWBRefConfig> PARSER = null;
        public static final int REFID_FIELD_NUMBER = 1;
        public static final int TEXTALIGN_FIELD_NUMBER = 9;
        public static final int TEXT_FIELD_NUMBER = 3;
        private int color_;
        private int defaultHeight_;
        private int defaultWidth_;
        private String fontFamily_ = "";
        private int fontSize_;
        private String imgUrl_ = "";
        private int lineHeight_;
        private String refId_ = "";
        private int textAlign_;
        private String text_ = "";

        private WXWBRefConfig() {
        }

        public String getRefId() {
            return this.refId_;
        }

        public ByteString getRefIdBytes() {
            return ByteString.copyFromUtf8(this.refId_);
        }

        /* access modifiers changed from: private */
        public void setRefId(String str) {
            Objects.requireNonNull(str);
            this.refId_ = str;
        }

        /* access modifiers changed from: private */
        public void clearRefId() {
            this.refId_ = getDefaultInstance().getRefId();
        }

        /* access modifiers changed from: private */
        public void setRefIdBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            checkByteStringIsUtf8(byteString);
            this.refId_ = byteString.toStringUtf8();
        }

        public String getImgUrl() {
            return this.imgUrl_;
        }

        public ByteString getImgUrlBytes() {
            return ByteString.copyFromUtf8(this.imgUrl_);
        }

        /* access modifiers changed from: private */
        public void setImgUrl(String str) {
            Objects.requireNonNull(str);
            this.imgUrl_ = str;
        }

        /* access modifiers changed from: private */
        public void clearImgUrl() {
            this.imgUrl_ = getDefaultInstance().getImgUrl();
        }

        /* access modifiers changed from: private */
        public void setImgUrlBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            checkByteStringIsUtf8(byteString);
            this.imgUrl_ = byteString.toStringUtf8();
        }

        public String getText() {
            return this.text_;
        }

        public ByteString getTextBytes() {
            return ByteString.copyFromUtf8(this.text_);
        }

        /* access modifiers changed from: private */
        public void setText(String str) {
            Objects.requireNonNull(str);
            this.text_ = str;
        }

        /* access modifiers changed from: private */
        public void clearText() {
            this.text_ = getDefaultInstance().getText();
        }

        /* access modifiers changed from: private */
        public void setTextBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            checkByteStringIsUtf8(byteString);
            this.text_ = byteString.toStringUtf8();
        }

        public int getFontSize() {
            return this.fontSize_;
        }

        /* access modifiers changed from: private */
        public void setFontSize(int i) {
            this.fontSize_ = i;
        }

        /* access modifiers changed from: private */
        public void clearFontSize() {
            this.fontSize_ = 0;
        }

        public String getFontFamily() {
            return this.fontFamily_;
        }

        public ByteString getFontFamilyBytes() {
            return ByteString.copyFromUtf8(this.fontFamily_);
        }

        /* access modifiers changed from: private */
        public void setFontFamily(String str) {
            Objects.requireNonNull(str);
            this.fontFamily_ = str;
        }

        /* access modifiers changed from: private */
        public void clearFontFamily() {
            this.fontFamily_ = getDefaultInstance().getFontFamily();
        }

        /* access modifiers changed from: private */
        public void setFontFamilyBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            checkByteStringIsUtf8(byteString);
            this.fontFamily_ = byteString.toStringUtf8();
        }

        public int getColor() {
            return this.color_;
        }

        /* access modifiers changed from: private */
        public void setColor(int i) {
            this.color_ = i;
        }

        /* access modifiers changed from: private */
        public void clearColor() {
            this.color_ = 0;
        }

        public int getLineHeight() {
            return this.lineHeight_;
        }

        /* access modifiers changed from: private */
        public void setLineHeight(int i) {
            this.lineHeight_ = i;
        }

        /* access modifiers changed from: private */
        public void clearLineHeight() {
            this.lineHeight_ = 0;
        }

        public int getTextAlign() {
            return this.textAlign_;
        }

        /* access modifiers changed from: private */
        public void setTextAlign(int i) {
            this.textAlign_ = i;
        }

        /* access modifiers changed from: private */
        public void clearTextAlign() {
            this.textAlign_ = 0;
        }

        public int getDefaultWidth() {
            return this.defaultWidth_;
        }

        /* access modifiers changed from: private */
        public void setDefaultWidth(int i) {
            this.defaultWidth_ = i;
        }

        /* access modifiers changed from: private */
        public void clearDefaultWidth() {
            this.defaultWidth_ = 0;
        }

        public int getDefaultHeight() {
            return this.defaultHeight_;
        }

        /* access modifiers changed from: private */
        public void setDefaultHeight(int i) {
            this.defaultHeight_ = i;
        }

        /* access modifiers changed from: private */
        public void clearDefaultHeight() {
            this.defaultHeight_ = 0;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.refId_.isEmpty()) {
                codedOutputStream.writeString(1, getRefId());
            }
            if (!this.imgUrl_.isEmpty()) {
                codedOutputStream.writeString(2, getImgUrl());
            }
            if (!this.text_.isEmpty()) {
                codedOutputStream.writeString(3, getText());
            }
            int i = this.fontSize_;
            if (i != 0) {
                codedOutputStream.writeInt32(4, i);
            }
            if (!this.fontFamily_.isEmpty()) {
                codedOutputStream.writeString(5, getFontFamily());
            }
            int i2 = this.color_;
            if (i2 != 0) {
                codedOutputStream.writeUInt32(6, i2);
            }
            int i3 = this.lineHeight_;
            if (i3 != 0) {
                codedOutputStream.writeInt32(7, i3);
            }
            int i4 = this.textAlign_;
            if (i4 != 0) {
                codedOutputStream.writeInt32(9, i4);
            }
            int i5 = this.defaultWidth_;
            if (i5 != 0) {
                codedOutputStream.writeInt32(10, i5);
            }
            int i6 = this.defaultHeight_;
            if (i6 != 0) {
                codedOutputStream.writeInt32(11, i6);
            }
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!this.refId_.isEmpty()) {
                i2 = 0 + CodedOutputStream.computeStringSize(1, getRefId());
            }
            if (!this.imgUrl_.isEmpty()) {
                i2 += CodedOutputStream.computeStringSize(2, getImgUrl());
            }
            if (!this.text_.isEmpty()) {
                i2 += CodedOutputStream.computeStringSize(3, getText());
            }
            int i3 = this.fontSize_;
            if (i3 != 0) {
                i2 += CodedOutputStream.computeInt32Size(4, i3);
            }
            if (!this.fontFamily_.isEmpty()) {
                i2 += CodedOutputStream.computeStringSize(5, getFontFamily());
            }
            int i4 = this.color_;
            if (i4 != 0) {
                i2 += CodedOutputStream.computeUInt32Size(6, i4);
            }
            int i5 = this.lineHeight_;
            if (i5 != 0) {
                i2 += CodedOutputStream.computeInt32Size(7, i5);
            }
            int i6 = this.textAlign_;
            if (i6 != 0) {
                i2 += CodedOutputStream.computeInt32Size(9, i6);
            }
            int i7 = this.defaultWidth_;
            if (i7 != 0) {
                i2 += CodedOutputStream.computeInt32Size(10, i7);
            }
            int i8 = this.defaultHeight_;
            if (i8 != 0) {
                i2 += CodedOutputStream.computeInt32Size(11, i8);
            }
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public static WXWBRefConfig parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static WXWBRefConfig parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static WXWBRefConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static WXWBRefConfig parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static WXWBRefConfig parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WXWBRefConfig parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WXWBRefConfig parseDelimitedFrom(InputStream inputStream) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WXWBRefConfig parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WXWBRefConfig parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static WXWBRefConfig parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WXWBRefConfig wXWBRefConfig) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(wXWBRefConfig);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<WXWBRefConfig, Builder> implements WXWBRefConfigOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(WXWBRefConfig.DEFAULT_INSTANCE);
            }

            public String getRefId() {
                return this.instance.getRefId();
            }

            public ByteString getRefIdBytes() {
                return this.instance.getRefIdBytes();
            }

            public Builder setRefId(String str) {
                copyOnWrite();
                this.instance.setRefId(str);
                return this;
            }

            public Builder clearRefId() {
                copyOnWrite();
                this.instance.clearRefId();
                return this;
            }

            public Builder setRefIdBytes(ByteString byteString) {
                copyOnWrite();
                this.instance.setRefIdBytes(byteString);
                return this;
            }

            public String getImgUrl() {
                return this.instance.getImgUrl();
            }

            public ByteString getImgUrlBytes() {
                return this.instance.getImgUrlBytes();
            }

            public Builder setImgUrl(String str) {
                copyOnWrite();
                this.instance.setImgUrl(str);
                return this;
            }

            public Builder clearImgUrl() {
                copyOnWrite();
                this.instance.clearImgUrl();
                return this;
            }

            public Builder setImgUrlBytes(ByteString byteString) {
                copyOnWrite();
                this.instance.setImgUrlBytes(byteString);
                return this;
            }

            public String getText() {
                return this.instance.getText();
            }

            public ByteString getTextBytes() {
                return this.instance.getTextBytes();
            }

            public Builder setText(String str) {
                copyOnWrite();
                this.instance.setText(str);
                return this;
            }

            public Builder clearText() {
                copyOnWrite();
                this.instance.clearText();
                return this;
            }

            public Builder setTextBytes(ByteString byteString) {
                copyOnWrite();
                this.instance.setTextBytes(byteString);
                return this;
            }

            public int getFontSize() {
                return this.instance.getFontSize();
            }

            public Builder setFontSize(int i) {
                copyOnWrite();
                this.instance.setFontSize(i);
                return this;
            }

            public Builder clearFontSize() {
                copyOnWrite();
                this.instance.clearFontSize();
                return this;
            }

            public String getFontFamily() {
                return this.instance.getFontFamily();
            }

            public ByteString getFontFamilyBytes() {
                return this.instance.getFontFamilyBytes();
            }

            public Builder setFontFamily(String str) {
                copyOnWrite();
                this.instance.setFontFamily(str);
                return this;
            }

            public Builder clearFontFamily() {
                copyOnWrite();
                this.instance.clearFontFamily();
                return this;
            }

            public Builder setFontFamilyBytes(ByteString byteString) {
                copyOnWrite();
                this.instance.setFontFamilyBytes(byteString);
                return this;
            }

            public int getColor() {
                return this.instance.getColor();
            }

            public Builder setColor(int i) {
                copyOnWrite();
                this.instance.setColor(i);
                return this;
            }

            public Builder clearColor() {
                copyOnWrite();
                this.instance.clearColor();
                return this;
            }

            public int getLineHeight() {
                return this.instance.getLineHeight();
            }

            public Builder setLineHeight(int i) {
                copyOnWrite();
                this.instance.setLineHeight(i);
                return this;
            }

            public Builder clearLineHeight() {
                copyOnWrite();
                this.instance.clearLineHeight();
                return this;
            }

            public int getTextAlign() {
                return this.instance.getTextAlign();
            }

            public Builder setTextAlign(int i) {
                copyOnWrite();
                this.instance.setTextAlign(i);
                return this;
            }

            public Builder clearTextAlign() {
                copyOnWrite();
                this.instance.clearTextAlign();
                return this;
            }

            public int getDefaultWidth() {
                return this.instance.getDefaultWidth();
            }

            public Builder setDefaultWidth(int i) {
                copyOnWrite();
                this.instance.setDefaultWidth(i);
                return this;
            }

            public Builder clearDefaultWidth() {
                copyOnWrite();
                this.instance.clearDefaultWidth();
                return this;
            }

            public int getDefaultHeight() {
                return this.instance.getDefaultHeight();
            }

            public Builder setDefaultHeight(int i) {
                copyOnWrite();
                this.instance.setDefaultHeight(i);
                return this;
            }

            public Builder clearDefaultHeight() {
                copyOnWrite();
                this.instance.clearDefaultHeight();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new WXWBRefConfig();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    WXWBRefConfig wXWBRefConfig = (WXWBRefConfig) obj2;
                    this.refId_ = visitor.visitString(!this.refId_.isEmpty(), this.refId_, !wXWBRefConfig.refId_.isEmpty(), wXWBRefConfig.refId_);
                    this.imgUrl_ = visitor.visitString(!this.imgUrl_.isEmpty(), this.imgUrl_, !wXWBRefConfig.imgUrl_.isEmpty(), wXWBRefConfig.imgUrl_);
                    this.text_ = visitor.visitString(!this.text_.isEmpty(), this.text_, !wXWBRefConfig.text_.isEmpty(), wXWBRefConfig.text_);
                    int i = this.fontSize_;
                    boolean z2 = i != 0;
                    int i2 = wXWBRefConfig.fontSize_;
                    this.fontSize_ = visitor.visitInt(z2, i, i2 != 0, i2);
                    this.fontFamily_ = visitor.visitString(!this.fontFamily_.isEmpty(), this.fontFamily_, !wXWBRefConfig.fontFamily_.isEmpty(), wXWBRefConfig.fontFamily_);
                    int i3 = this.color_;
                    boolean z3 = i3 != 0;
                    int i4 = wXWBRefConfig.color_;
                    this.color_ = visitor.visitInt(z3, i3, i4 != 0, i4);
                    int i5 = this.lineHeight_;
                    boolean z4 = i5 != 0;
                    int i6 = wXWBRefConfig.lineHeight_;
                    this.lineHeight_ = visitor.visitInt(z4, i5, i6 != 0, i6);
                    int i7 = this.textAlign_;
                    boolean z5 = i7 != 0;
                    int i8 = wXWBRefConfig.textAlign_;
                    this.textAlign_ = visitor.visitInt(z5, i7, i8 != 0, i8);
                    int i9 = this.defaultWidth_;
                    boolean z6 = i9 != 0;
                    int i10 = wXWBRefConfig.defaultWidth_;
                    this.defaultWidth_ = visitor.visitInt(z6, i9, i10 != 0, i10);
                    int i11 = this.defaultHeight_;
                    boolean z7 = i11 != 0;
                    int i12 = wXWBRefConfig.defaultHeight_;
                    if (i12 != 0) {
                        z = true;
                    }
                    this.defaultHeight_ = visitor.visitInt(z7, i11, z, i12);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z = true;
                                    break;
                                case 10:
                                    this.refId_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 18:
                                    this.imgUrl_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 26:
                                    this.text_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 32:
                                    this.fontSize_ = codedInputStream.readInt32();
                                    break;
                                case 42:
                                    this.fontFamily_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 48:
                                    this.color_ = codedInputStream.readUInt32();
                                    break;
                                case 56:
                                    this.lineHeight_ = codedInputStream.readInt32();
                                    break;
                                case 72:
                                    this.textAlign_ = codedInputStream.readInt32();
                                    break;
                                case 80:
                                    this.defaultWidth_ = codedInputStream.readInt32();
                                    break;
                                case 88:
                                    this.defaultHeight_ = codedInputStream.readInt32();
                                    break;
                                default:
                                    if (codedInputStream.skipField(readTag)) {
                                        break;
                                    }
                                    z = true;
                                    break;
                            }
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (WXWBRefConfig.class) {
                            if (PARSER == null) {
                                PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }
                    return PARSER;
                default:
                    throw new UnsupportedOperationException();
            }
            return DEFAULT_INSTANCE;
        }

        static {
            WXWBRefConfig wXWBRefConfig = new WXWBRefConfig();
            DEFAULT_INSTANCE = wXWBRefConfig;
            wXWBRefConfig.makeImmutable();
        }

        public static WXWBRefConfig getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WXWBRefConfig> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class WXWBSelectAreaConfig extends GeneratedMessageLite<WXWBSelectAreaConfig, Builder> implements WXWBSelectAreaConfigOrBuilder {
        /* access modifiers changed from: private */
        public static final WXWBSelectAreaConfig DEFAULT_INSTANCE;
        public static final int LASSOOFFSET_FIELD_NUMBER = 7;
        public static final int LAYERLOCS_FIELD_NUMBER = 6;
        public static final int LINEINDEXS_FIELD_NUMBER = 1;
        public static final int LINEOFFSETS_FIELD_NUMBER = 5;
        private static volatile Parser<WXWBSelectAreaConfig> PARSER = null;
        public static final int SHAPEINDEXS_FIELD_NUMBER = 2;
        private int bitField0_;
        private WXWBOffset lassoOffset_;
        private MapFieldLite<Long, WXWBChooseShapeOffset> layerLocs_ = MapFieldLite.emptyMapField();
        private Internal.LongList lineIndexs_ = emptyLongList();
        private MapFieldLite<Long, WXWBOffset> lineOffsets_ = MapFieldLite.emptyMapField();
        private Internal.LongList shapeIndexs_ = emptyLongList();

        private WXWBSelectAreaConfig() {
        }

        public List<Long> getLineIndexsList() {
            return this.lineIndexs_;
        }

        public int getLineIndexsCount() {
            return this.lineIndexs_.size();
        }

        public long getLineIndexs(int i) {
            return this.lineIndexs_.getLong(i);
        }

        private void ensureLineIndexsIsMutable() {
            if (!this.lineIndexs_.isModifiable()) {
                this.lineIndexs_ = GeneratedMessageLite.mutableCopy(this.lineIndexs_);
            }
        }

        /* access modifiers changed from: private */
        public void setLineIndexs(int i, long j) {
            ensureLineIndexsIsMutable();
            this.lineIndexs_.setLong(i, j);
        }

        /* access modifiers changed from: private */
        public void addLineIndexs(long j) {
            ensureLineIndexsIsMutable();
            this.lineIndexs_.addLong(j);
        }

        /* access modifiers changed from: private */
        public void addAllLineIndexs(Iterable<? extends Long> iterable) {
            ensureLineIndexsIsMutable();
            AbstractMessageLite.addAll(iterable, this.lineIndexs_);
        }

        /* access modifiers changed from: private */
        public void clearLineIndexs() {
            this.lineIndexs_ = emptyLongList();
        }

        public List<Long> getShapeIndexsList() {
            return this.shapeIndexs_;
        }

        public int getShapeIndexsCount() {
            return this.shapeIndexs_.size();
        }

        public long getShapeIndexs(int i) {
            return this.shapeIndexs_.getLong(i);
        }

        private void ensureShapeIndexsIsMutable() {
            if (!this.shapeIndexs_.isModifiable()) {
                this.shapeIndexs_ = GeneratedMessageLite.mutableCopy(this.shapeIndexs_);
            }
        }

        /* access modifiers changed from: private */
        public void setShapeIndexs(int i, long j) {
            ensureShapeIndexsIsMutable();
            this.shapeIndexs_.setLong(i, j);
        }

        /* access modifiers changed from: private */
        public void addShapeIndexs(long j) {
            ensureShapeIndexsIsMutable();
            this.shapeIndexs_.addLong(j);
        }

        /* access modifiers changed from: private */
        public void addAllShapeIndexs(Iterable<? extends Long> iterable) {
            ensureShapeIndexsIsMutable();
            AbstractMessageLite.addAll(iterable, this.shapeIndexs_);
        }

        /* access modifiers changed from: private */
        public void clearShapeIndexs() {
            this.shapeIndexs_ = emptyLongList();
        }

        private static final class LineOffsetsDefaultEntryHolder {
            static final MapEntryLite<Long, WXWBOffset> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.UINT64, 0L, WireFormat.FieldType.MESSAGE, WXWBOffset.getDefaultInstance());

            private LineOffsetsDefaultEntryHolder() {
            }
        }

        private MapFieldLite<Long, WXWBOffset> internalGetLineOffsets() {
            return this.lineOffsets_;
        }

        private MapFieldLite<Long, WXWBOffset> internalGetMutableLineOffsets() {
            if (!this.lineOffsets_.isMutable()) {
                this.lineOffsets_ = this.lineOffsets_.mutableCopy();
            }
            return this.lineOffsets_;
        }

        public int getLineOffsetsCount() {
            return internalGetLineOffsets().size();
        }

        public boolean containsLineOffsets(long j) {
            return internalGetLineOffsets().containsKey(Long.valueOf(j));
        }

        @Deprecated
        public Map<Long, WXWBOffset> getLineOffsets() {
            return getLineOffsetsMap();
        }

        public Map<Long, WXWBOffset> getLineOffsetsMap() {
            return Collections.unmodifiableMap(internalGetLineOffsets());
        }

        public WXWBOffset getLineOffsetsOrDefault(long j, WXWBOffset wXWBOffset) {
            MapFieldLite<Long, WXWBOffset> internalGetLineOffsets = internalGetLineOffsets();
            return internalGetLineOffsets.containsKey(Long.valueOf(j)) ? (WXWBOffset) internalGetLineOffsets.get(Long.valueOf(j)) : wXWBOffset;
        }

        public WXWBOffset getLineOffsetsOrThrow(long j) {
            MapFieldLite<Long, WXWBOffset> internalGetLineOffsets = internalGetLineOffsets();
            if (internalGetLineOffsets.containsKey(Long.valueOf(j))) {
                return (WXWBOffset) internalGetLineOffsets.get(Long.valueOf(j));
            }
            throw new IllegalArgumentException();
        }

        /* access modifiers changed from: private */
        public Map<Long, WXWBOffset> getMutableLineOffsetsMap() {
            return internalGetMutableLineOffsets();
        }

        private static final class LayerLocsDefaultEntryHolder {
            static final MapEntryLite<Long, WXWBChooseShapeOffset> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.UINT64, 0L, WireFormat.FieldType.MESSAGE, WXWBChooseShapeOffset.getDefaultInstance());

            private LayerLocsDefaultEntryHolder() {
            }
        }

        private MapFieldLite<Long, WXWBChooseShapeOffset> internalGetLayerLocs() {
            return this.layerLocs_;
        }

        private MapFieldLite<Long, WXWBChooseShapeOffset> internalGetMutableLayerLocs() {
            if (!this.layerLocs_.isMutable()) {
                this.layerLocs_ = this.layerLocs_.mutableCopy();
            }
            return this.layerLocs_;
        }

        public int getLayerLocsCount() {
            return internalGetLayerLocs().size();
        }

        public boolean containsLayerLocs(long j) {
            return internalGetLayerLocs().containsKey(Long.valueOf(j));
        }

        @Deprecated
        public Map<Long, WXWBChooseShapeOffset> getLayerLocs() {
            return getLayerLocsMap();
        }

        public Map<Long, WXWBChooseShapeOffset> getLayerLocsMap() {
            return Collections.unmodifiableMap(internalGetLayerLocs());
        }

        public WXWBChooseShapeOffset getLayerLocsOrDefault(long j, WXWBChooseShapeOffset wXWBChooseShapeOffset) {
            MapFieldLite<Long, WXWBChooseShapeOffset> internalGetLayerLocs = internalGetLayerLocs();
            return internalGetLayerLocs.containsKey(Long.valueOf(j)) ? (WXWBChooseShapeOffset) internalGetLayerLocs.get(Long.valueOf(j)) : wXWBChooseShapeOffset;
        }

        public WXWBChooseShapeOffset getLayerLocsOrThrow(long j) {
            MapFieldLite<Long, WXWBChooseShapeOffset> internalGetLayerLocs = internalGetLayerLocs();
            if (internalGetLayerLocs.containsKey(Long.valueOf(j))) {
                return (WXWBChooseShapeOffset) internalGetLayerLocs.get(Long.valueOf(j));
            }
            throw new IllegalArgumentException();
        }

        /* access modifiers changed from: private */
        public Map<Long, WXWBChooseShapeOffset> getMutableLayerLocsMap() {
            return internalGetMutableLayerLocs();
        }

        public boolean hasLassoOffset() {
            return this.lassoOffset_ != null;
        }

        public WXWBOffset getLassoOffset() {
            WXWBOffset wXWBOffset = this.lassoOffset_;
            return wXWBOffset == null ? WXWBOffset.getDefaultInstance() : wXWBOffset;
        }

        /* access modifiers changed from: private */
        public void setLassoOffset(WXWBOffset wXWBOffset) {
            Objects.requireNonNull(wXWBOffset);
            this.lassoOffset_ = wXWBOffset;
        }

        /* access modifiers changed from: private */
        public void setLassoOffset(WXWBOffset.Builder builder) {
            this.lassoOffset_ = builder.build();
        }

        /* access modifiers changed from: private */
        public void mergeLassoOffset(WXWBOffset wXWBOffset) {
            WXWBOffset wXWBOffset2 = this.lassoOffset_;
            if (wXWBOffset2 == null || wXWBOffset2 == WXWBOffset.getDefaultInstance()) {
                this.lassoOffset_ = wXWBOffset;
            } else {
                this.lassoOffset_ = WXWBOffset.newBuilder(this.lassoOffset_).mergeFrom(wXWBOffset).buildPartial();
            }
        }

        /* access modifiers changed from: private */
        public void clearLassoOffset() {
            this.lassoOffset_ = null;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.lineIndexs_.size(); i++) {
                codedOutputStream.writeUInt64(1, this.lineIndexs_.getLong(i));
            }
            for (int i2 = 0; i2 < this.shapeIndexs_.size(); i2++) {
                codedOutputStream.writeUInt64(2, this.shapeIndexs_.getLong(i2));
            }
            for (Map.Entry entry : internalGetLineOffsets().entrySet()) {
                LineOffsetsDefaultEntryHolder.defaultEntry.serializeTo(codedOutputStream, 5, entry.getKey(), entry.getValue());
            }
            for (Map.Entry entry2 : internalGetLayerLocs().entrySet()) {
                LayerLocsDefaultEntryHolder.defaultEntry.serializeTo(codedOutputStream, 6, entry2.getKey(), entry2.getValue());
            }
            if (this.lassoOffset_ != null) {
                codedOutputStream.writeMessage(7, getLassoOffset());
            }
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.lineIndexs_.size(); i3++) {
                i2 += CodedOutputStream.computeUInt64SizeNoTag(this.lineIndexs_.getLong(i3));
            }
            int size = i2 + 0 + (getLineIndexsList().size() * 1);
            int i4 = 0;
            for (int i5 = 0; i5 < this.shapeIndexs_.size(); i5++) {
                i4 += CodedOutputStream.computeUInt64SizeNoTag(this.shapeIndexs_.getLong(i5));
            }
            int size2 = size + i4 + (getShapeIndexsList().size() * 1);
            for (Map.Entry entry : internalGetLineOffsets().entrySet()) {
                size2 += LineOffsetsDefaultEntryHolder.defaultEntry.computeMessageSize(5, entry.getKey(), entry.getValue());
            }
            for (Map.Entry entry2 : internalGetLayerLocs().entrySet()) {
                size2 += LayerLocsDefaultEntryHolder.defaultEntry.computeMessageSize(6, entry2.getKey(), entry2.getValue());
            }
            if (this.lassoOffset_ != null) {
                size2 += CodedOutputStream.computeMessageSize(7, getLassoOffset());
            }
            this.memoizedSerializedSize = size2;
            return size2;
        }

        public static WXWBSelectAreaConfig parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static WXWBSelectAreaConfig parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static WXWBSelectAreaConfig parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static WXWBSelectAreaConfig parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static WXWBSelectAreaConfig parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WXWBSelectAreaConfig parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WXWBSelectAreaConfig parseDelimitedFrom(InputStream inputStream) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WXWBSelectAreaConfig parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WXWBSelectAreaConfig parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static WXWBSelectAreaConfig parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WXWBSelectAreaConfig wXWBSelectAreaConfig) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(wXWBSelectAreaConfig);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<WXWBSelectAreaConfig, Builder> implements WXWBSelectAreaConfigOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(WXWBSelectAreaConfig.DEFAULT_INSTANCE);
            }

            public List<Long> getLineIndexsList() {
                return Collections.unmodifiableList(this.instance.getLineIndexsList());
            }

            public int getLineIndexsCount() {
                return this.instance.getLineIndexsCount();
            }

            public long getLineIndexs(int i) {
                return this.instance.getLineIndexs(i);
            }

            public Builder setLineIndexs(int i, long j) {
                copyOnWrite();
                this.instance.setLineIndexs(i, j);
                return this;
            }

            public Builder addLineIndexs(long j) {
                copyOnWrite();
                this.instance.addLineIndexs(j);
                return this;
            }

            public Builder addAllLineIndexs(Iterable<? extends Long> iterable) {
                copyOnWrite();
                this.instance.addAllLineIndexs(iterable);
                return this;
            }

            public Builder clearLineIndexs() {
                copyOnWrite();
                this.instance.clearLineIndexs();
                return this;
            }

            public List<Long> getShapeIndexsList() {
                return Collections.unmodifiableList(this.instance.getShapeIndexsList());
            }

            public int getShapeIndexsCount() {
                return this.instance.getShapeIndexsCount();
            }

            public long getShapeIndexs(int i) {
                return this.instance.getShapeIndexs(i);
            }

            public Builder setShapeIndexs(int i, long j) {
                copyOnWrite();
                this.instance.setShapeIndexs(i, j);
                return this;
            }

            public Builder addShapeIndexs(long j) {
                copyOnWrite();
                this.instance.addShapeIndexs(j);
                return this;
            }

            public Builder addAllShapeIndexs(Iterable<? extends Long> iterable) {
                copyOnWrite();
                this.instance.addAllShapeIndexs(iterable);
                return this;
            }

            public Builder clearShapeIndexs() {
                copyOnWrite();
                this.instance.clearShapeIndexs();
                return this;
            }

            public int getLineOffsetsCount() {
                return this.instance.getLineOffsetsMap().size();
            }

            public boolean containsLineOffsets(long j) {
                return this.instance.getLineOffsetsMap().containsKey(Long.valueOf(j));
            }

            public Builder clearLineOffsets() {
                copyOnWrite();
                this.instance.getMutableLineOffsetsMap().clear();
                return this;
            }

            public Builder removeLineOffsets(long j) {
                copyOnWrite();
                this.instance.getMutableLineOffsetsMap().remove(Long.valueOf(j));
                return this;
            }

            @Deprecated
            public Map<Long, WXWBOffset> getLineOffsets() {
                return getLineOffsetsMap();
            }

            public Map<Long, WXWBOffset> getLineOffsetsMap() {
                return Collections.unmodifiableMap(this.instance.getLineOffsetsMap());
            }

            public WXWBOffset getLineOffsetsOrDefault(long j, WXWBOffset wXWBOffset) {
                Map<Long, WXWBOffset> lineOffsetsMap = this.instance.getLineOffsetsMap();
                return lineOffsetsMap.containsKey(Long.valueOf(j)) ? lineOffsetsMap.get(Long.valueOf(j)) : wXWBOffset;
            }

            public WXWBOffset getLineOffsetsOrThrow(long j) {
                Map<Long, WXWBOffset> lineOffsetsMap = this.instance.getLineOffsetsMap();
                if (lineOffsetsMap.containsKey(Long.valueOf(j))) {
                    return lineOffsetsMap.get(Long.valueOf(j));
                }
                throw new IllegalArgumentException();
            }

            public Builder putLineOffsets(long j, WXWBOffset wXWBOffset) {
                Objects.requireNonNull(wXWBOffset);
                copyOnWrite();
                this.instance.getMutableLineOffsetsMap().put(Long.valueOf(j), wXWBOffset);
                return this;
            }

            public Builder putAllLineOffsets(Map<Long, WXWBOffset> map) {
                copyOnWrite();
                this.instance.getMutableLineOffsetsMap().putAll(map);
                return this;
            }

            public int getLayerLocsCount() {
                return this.instance.getLayerLocsMap().size();
            }

            public boolean containsLayerLocs(long j) {
                return this.instance.getLayerLocsMap().containsKey(Long.valueOf(j));
            }

            public Builder clearLayerLocs() {
                copyOnWrite();
                this.instance.getMutableLayerLocsMap().clear();
                return this;
            }

            public Builder removeLayerLocs(long j) {
                copyOnWrite();
                this.instance.getMutableLayerLocsMap().remove(Long.valueOf(j));
                return this;
            }

            @Deprecated
            public Map<Long, WXWBChooseShapeOffset> getLayerLocs() {
                return getLayerLocsMap();
            }

            public Map<Long, WXWBChooseShapeOffset> getLayerLocsMap() {
                return Collections.unmodifiableMap(this.instance.getLayerLocsMap());
            }

            public WXWBChooseShapeOffset getLayerLocsOrDefault(long j, WXWBChooseShapeOffset wXWBChooseShapeOffset) {
                Map<Long, WXWBChooseShapeOffset> layerLocsMap = this.instance.getLayerLocsMap();
                return layerLocsMap.containsKey(Long.valueOf(j)) ? layerLocsMap.get(Long.valueOf(j)) : wXWBChooseShapeOffset;
            }

            public WXWBChooseShapeOffset getLayerLocsOrThrow(long j) {
                Map<Long, WXWBChooseShapeOffset> layerLocsMap = this.instance.getLayerLocsMap();
                if (layerLocsMap.containsKey(Long.valueOf(j))) {
                    return layerLocsMap.get(Long.valueOf(j));
                }
                throw new IllegalArgumentException();
            }

            public Builder putLayerLocs(long j, WXWBChooseShapeOffset wXWBChooseShapeOffset) {
                Objects.requireNonNull(wXWBChooseShapeOffset);
                copyOnWrite();
                this.instance.getMutableLayerLocsMap().put(Long.valueOf(j), wXWBChooseShapeOffset);
                return this;
            }

            public Builder putAllLayerLocs(Map<Long, WXWBChooseShapeOffset> map) {
                copyOnWrite();
                this.instance.getMutableLayerLocsMap().putAll(map);
                return this;
            }

            public boolean hasLassoOffset() {
                return this.instance.hasLassoOffset();
            }

            public WXWBOffset getLassoOffset() {
                return this.instance.getLassoOffset();
            }

            public Builder setLassoOffset(WXWBOffset wXWBOffset) {
                copyOnWrite();
                this.instance.setLassoOffset(wXWBOffset);
                return this;
            }

            public Builder setLassoOffset(WXWBOffset.Builder builder) {
                copyOnWrite();
                this.instance.setLassoOffset(builder);
                return this;
            }

            public Builder mergeLassoOffset(WXWBOffset wXWBOffset) {
                copyOnWrite();
                this.instance.mergeLassoOffset(wXWBOffset);
                return this;
            }

            public Builder clearLassoOffset() {
                copyOnWrite();
                this.instance.clearLassoOffset();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new WXWBSelectAreaConfig();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.lineIndexs_.makeImmutable();
                    this.shapeIndexs_.makeImmutable();
                    this.lineOffsets_.makeImmutable();
                    this.layerLocs_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = (GeneratedMessageLite.Visitor) obj;
                    WXWBSelectAreaConfig wXWBSelectAreaConfig = (WXWBSelectAreaConfig) obj2;
                    this.lineIndexs_ = mergeFromVisitor.visitLongList(this.lineIndexs_, wXWBSelectAreaConfig.lineIndexs_);
                    this.shapeIndexs_ = mergeFromVisitor.visitLongList(this.shapeIndexs_, wXWBSelectAreaConfig.shapeIndexs_);
                    this.lineOffsets_ = mergeFromVisitor.visitMap(this.lineOffsets_, wXWBSelectAreaConfig.internalGetLineOffsets());
                    this.layerLocs_ = mergeFromVisitor.visitMap(this.layerLocs_, wXWBSelectAreaConfig.internalGetLayerLocs());
                    this.lassoOffset_ = mergeFromVisitor.visitMessage(this.lassoOffset_, wXWBSelectAreaConfig.lassoOffset_);
                    if (mergeFromVisitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= wXWBSelectAreaConfig.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    boolean z = false;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 8) {
                                    if (!this.lineIndexs_.isModifiable()) {
                                        this.lineIndexs_ = GeneratedMessageLite.mutableCopy(this.lineIndexs_);
                                    }
                                    this.lineIndexs_.addLong(codedInputStream.readUInt64());
                                } else if (readTag == 10) {
                                    int pushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if (!this.lineIndexs_.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.lineIndexs_ = GeneratedMessageLite.mutableCopy(this.lineIndexs_);
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.lineIndexs_.addLong(codedInputStream.readUInt64());
                                    }
                                    codedInputStream.popLimit(pushLimit);
                                } else if (readTag == 16) {
                                    if (!this.shapeIndexs_.isModifiable()) {
                                        this.shapeIndexs_ = GeneratedMessageLite.mutableCopy(this.shapeIndexs_);
                                    }
                                    this.shapeIndexs_.addLong(codedInputStream.readUInt64());
                                } else if (readTag == 18) {
                                    int pushLimit2 = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                                    if (!this.shapeIndexs_.isModifiable() && codedInputStream.getBytesUntilLimit() > 0) {
                                        this.shapeIndexs_ = GeneratedMessageLite.mutableCopy(this.shapeIndexs_);
                                    }
                                    while (codedInputStream.getBytesUntilLimit() > 0) {
                                        this.shapeIndexs_.addLong(codedInputStream.readUInt64());
                                    }
                                    codedInputStream.popLimit(pushLimit2);
                                } else if (readTag == 42) {
                                    if (!this.lineOffsets_.isMutable()) {
                                        this.lineOffsets_ = this.lineOffsets_.mutableCopy();
                                    }
                                    LineOffsetsDefaultEntryHolder.defaultEntry.parseInto(this.lineOffsets_, codedInputStream, extensionRegistryLite);
                                } else if (readTag == 50) {
                                    if (!this.layerLocs_.isMutable()) {
                                        this.layerLocs_ = this.layerLocs_.mutableCopy();
                                    }
                                    LayerLocsDefaultEntryHolder.defaultEntry.parseInto(this.layerLocs_, codedInputStream, extensionRegistryLite);
                                } else if (readTag == 58) {
                                    WXWBOffset wXWBOffset = this.lassoOffset_;
                                    WXWBOffset.Builder builder = wXWBOffset != null ? (WXWBOffset.Builder) wXWBOffset.toBuilder() : null;
                                    WXWBOffset readMessage = codedInputStream.readMessage(WXWBOffset.parser(), extensionRegistryLite);
                                    this.lassoOffset_ = readMessage;
                                    if (builder != null) {
                                        builder.mergeFrom(readMessage);
                                        this.lassoOffset_ = builder.buildPartial();
                                    }
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (WXWBSelectAreaConfig.class) {
                            if (PARSER == null) {
                                PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }
                    return PARSER;
                default:
                    throw new UnsupportedOperationException();
            }
            return DEFAULT_INSTANCE;
        }

        static {
            WXWBSelectAreaConfig wXWBSelectAreaConfig = new WXWBSelectAreaConfig();
            DEFAULT_INSTANCE = wXWBSelectAreaConfig;
            wXWBSelectAreaConfig.makeImmutable();
        }

        public static WXWBSelectAreaConfig getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WXWBSelectAreaConfig> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class WXWBTCPPacketData extends GeneratedMessageLite<WXWBTCPPacketData, Builder> implements WXWBTCPPacketDataOrBuilder {
        public static final int BUSINESSTYPE_FIELD_NUMBER = 1001;
        public static final int CANVASINFO_FIELD_NUMBER = 31;
        public static final int CHOOSECONFIG_FIELD_NUMBER = 20;
        public static final int COMPASSESCONFIG_FIELD_NUMBER = 22;
        public static final int COURSEID_FIELD_NUMBER = 3;
        public static final int CURSORPOSITION_FIELD_NUMBER = 33;
        public static final int DATACREATETIMESTAMP_FIELD_NUMBER = 14;
        /* access modifiers changed from: private */
        public static final WXWBTCPPacketData DEFAULT_INSTANCE;
        public static final int FILLCOLOR_FIELD_NUMBER = 16;
        public static final int HEIGHT_FIELD_NUMBER = 9;
        public static final int LINEINDEX_FIELD_NUMBER = 5;
        public static final int LINETYPE_FIELD_NUMBER = 17;
        public static final int LINEWIDTH_FIELD_NUMBER = 12;
        public static final int MSGID_FIELD_NUMBER = 11;
        public static final int MYBUSINESS_FIELD_NUMBER = 1000;
        public static final int PAGECONFIG_FIELD_NUMBER = 18;
        public static final int PAGEID_FIELD_NUMBER = 4;
        private static volatile Parser<WXWBTCPPacketData> PARSER = null;
        public static final int POINTLIST_FIELD_NUMBER = 7;
        public static final int POINTTYPE_FIELD_NUMBER = 2;
        public static final int REFCONFIG_FIELD_NUMBER = 23;
        public static final int REVOKEANDRECOVERCONFIG_FIELD_NUMBER = 19;
        public static final int ROTATION_FIELD_NUMBER = 15;
        public static final int RULERCONFIG_FIELD_NUMBER = 21;
        public static final int SELECTCONFIG_FIELD_NUMBER = 32;
        public static final int STROKECOLOR_FIELD_NUMBER = 13;
        public static final int TYPE_FIELD_NUMBER = 1;
        public static final int UID_FIELD_NUMBER = 30;
        public static final int USERINFO_FIELD_NUMBER = 27;
        public static final int WIDTH_FIELD_NUMBER = 8;
        private int bitField0_;
        private int businessType_;
        private WXWBCanvasInfo canvasInfo_;
        private WXWBChooseConfig chooseConfig_;
        private WXWBCompassesConfig compassesConfig_;
        private String courseId_ = "";
        private WXWBPoint cursorPosition_;
        private long dataCreateTimestamp_;
        private int fillColor_;
        private int height_;
        private long lineIndex_;
        private int lineType_;
        private float lineWidth_;
        private long msgId_;
        private Any myBusiness_;
        private WXWBPageConfig pageConfig_;
        private String pageId_ = "";
        private Internal.ProtobufList<WXWBPoint> pointList_ = emptyProtobufList();
        private int pointType_;
        private WXWBRefConfig refConfig_;
        private WXWBRevokeAndRecoverConfig revokeAndRecoverConfig_;
        private float rotation_;
        private WXWBRulerConfig rulerConfig_;
        private WXWBSelectAreaConfig selectConfig_;
        private int strokeColor_;
        private int type_;
        private String uid_ = "";
        private WXWBUserInfo userInfo_;
        private int width_;

        private WXWBTCPPacketData() {
        }

        public int getTypeValue() {
            return this.type_;
        }

        public WXWBMessageType getType() {
            WXWBMessageType forNumber = WXWBMessageType.forNumber(this.type_);
            return forNumber == null ? WXWBMessageType.UNRECOGNIZED : forNumber;
        }

        /* access modifiers changed from: private */
        public void setTypeValue(int i) {
            this.type_ = i;
        }

        /* access modifiers changed from: private */
        public void setType(WXWBMessageType wXWBMessageType) {
            Objects.requireNonNull(wXWBMessageType);
            this.type_ = wXWBMessageType.getNumber();
        }

        /* access modifiers changed from: private */
        public void clearType() {
            this.type_ = 0;
        }

        public int getPointTypeValue() {
            return this.pointType_;
        }

        public WXTPointType getPointType() {
            WXTPointType forNumber = WXTPointType.forNumber(this.pointType_);
            return forNumber == null ? WXTPointType.UNRECOGNIZED : forNumber;
        }

        /* access modifiers changed from: private */
        public void setPointTypeValue(int i) {
            this.pointType_ = i;
        }

        /* access modifiers changed from: private */
        public void setPointType(WXTPointType wXTPointType) {
            Objects.requireNonNull(wXTPointType);
            this.pointType_ = wXTPointType.getNumber();
        }

        /* access modifiers changed from: private */
        public void clearPointType() {
            this.pointType_ = 0;
        }

        public String getCourseId() {
            return this.courseId_;
        }

        public ByteString getCourseIdBytes() {
            return ByteString.copyFromUtf8(this.courseId_);
        }

        /* access modifiers changed from: private */
        public void setCourseId(String str) {
            Objects.requireNonNull(str);
            this.courseId_ = str;
        }

        /* access modifiers changed from: private */
        public void clearCourseId() {
            this.courseId_ = getDefaultInstance().getCourseId();
        }

        /* access modifiers changed from: private */
        public void setCourseIdBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            checkByteStringIsUtf8(byteString);
            this.courseId_ = byteString.toStringUtf8();
        }

        public String getPageId() {
            return this.pageId_;
        }

        public ByteString getPageIdBytes() {
            return ByteString.copyFromUtf8(this.pageId_);
        }

        /* access modifiers changed from: private */
        public void setPageId(String str) {
            Objects.requireNonNull(str);
            this.pageId_ = str;
        }

        /* access modifiers changed from: private */
        public void clearPageId() {
            this.pageId_ = getDefaultInstance().getPageId();
        }

        /* access modifiers changed from: private */
        public void setPageIdBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            checkByteStringIsUtf8(byteString);
            this.pageId_ = byteString.toStringUtf8();
        }

        public long getLineIndex() {
            return this.lineIndex_;
        }

        /* access modifiers changed from: private */
        public void setLineIndex(long j) {
            this.lineIndex_ = j;
        }

        /* access modifiers changed from: private */
        public void clearLineIndex() {
            this.lineIndex_ = 0;
        }

        public List<WXWBPoint> getPointListList() {
            return this.pointList_;
        }

        public List<? extends WXWBPointOrBuilder> getPointListOrBuilderList() {
            return this.pointList_;
        }

        public int getPointListCount() {
            return this.pointList_.size();
        }

        public WXWBPoint getPointList(int i) {
            return (WXWBPoint) this.pointList_.get(i);
        }

        public WXWBPointOrBuilder getPointListOrBuilder(int i) {
            return (WXWBPointOrBuilder) this.pointList_.get(i);
        }

        private void ensurePointListIsMutable() {
            if (!this.pointList_.isModifiable()) {
                this.pointList_ = GeneratedMessageLite.mutableCopy(this.pointList_);
            }
        }

        /* access modifiers changed from: private */
        public void setPointList(int i, WXWBPoint wXWBPoint) {
            Objects.requireNonNull(wXWBPoint);
            ensurePointListIsMutable();
            this.pointList_.set(i, wXWBPoint);
        }

        /* access modifiers changed from: private */
        public void setPointList(int i, WXWBPoint.Builder builder) {
            ensurePointListIsMutable();
            this.pointList_.set(i, builder.build());
        }

        /* access modifiers changed from: private */
        public void addPointList(WXWBPoint wXWBPoint) {
            Objects.requireNonNull(wXWBPoint);
            ensurePointListIsMutable();
            this.pointList_.add(wXWBPoint);
        }

        /* access modifiers changed from: private */
        public void addPointList(int i, WXWBPoint wXWBPoint) {
            Objects.requireNonNull(wXWBPoint);
            ensurePointListIsMutable();
            this.pointList_.add(i, wXWBPoint);
        }

        /* access modifiers changed from: private */
        public void addPointList(WXWBPoint.Builder builder) {
            ensurePointListIsMutable();
            this.pointList_.add(builder.build());
        }

        /* access modifiers changed from: private */
        public void addPointList(int i, WXWBPoint.Builder builder) {
            ensurePointListIsMutable();
            this.pointList_.add(i, builder.build());
        }

        /* access modifiers changed from: private */
        public void addAllPointList(Iterable<? extends WXWBPoint> iterable) {
            ensurePointListIsMutable();
            AbstractMessageLite.addAll(iterable, this.pointList_);
        }

        /* access modifiers changed from: private */
        public void clearPointList() {
            this.pointList_ = emptyProtobufList();
        }

        /* access modifiers changed from: private */
        public void removePointList(int i) {
            ensurePointListIsMutable();
            this.pointList_.remove(i);
        }

        public int getWidth() {
            return this.width_;
        }

        /* access modifiers changed from: private */
        public void setWidth(int i) {
            this.width_ = i;
        }

        /* access modifiers changed from: private */
        public void clearWidth() {
            this.width_ = 0;
        }

        public int getHeight() {
            return this.height_;
        }

        /* access modifiers changed from: private */
        public void setHeight(int i) {
            this.height_ = i;
        }

        /* access modifiers changed from: private */
        public void clearHeight() {
            this.height_ = 0;
        }

        public long getMsgId() {
            return this.msgId_;
        }

        /* access modifiers changed from: private */
        public void setMsgId(long j) {
            this.msgId_ = j;
        }

        /* access modifiers changed from: private */
        public void clearMsgId() {
            this.msgId_ = 0;
        }

        public float getLineWidth() {
            return this.lineWidth_;
        }

        /* access modifiers changed from: private */
        public void setLineWidth(float f) {
            this.lineWidth_ = f;
        }

        /* access modifiers changed from: private */
        public void clearLineWidth() {
            this.lineWidth_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public int getStrokeColor() {
            return this.strokeColor_;
        }

        /* access modifiers changed from: private */
        public void setStrokeColor(int i) {
            this.strokeColor_ = i;
        }

        /* access modifiers changed from: private */
        public void clearStrokeColor() {
            this.strokeColor_ = 0;
        }

        public long getDataCreateTimestamp() {
            return this.dataCreateTimestamp_;
        }

        /* access modifiers changed from: private */
        public void setDataCreateTimestamp(long j) {
            this.dataCreateTimestamp_ = j;
        }

        /* access modifiers changed from: private */
        public void clearDataCreateTimestamp() {
            this.dataCreateTimestamp_ = 0;
        }

        public float getRotation() {
            return this.rotation_;
        }

        /* access modifiers changed from: private */
        public void setRotation(float f) {
            this.rotation_ = f;
        }

        /* access modifiers changed from: private */
        public void clearRotation() {
            this.rotation_ = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public int getFillColor() {
            return this.fillColor_;
        }

        /* access modifiers changed from: private */
        public void setFillColor(int i) {
            this.fillColor_ = i;
        }

        /* access modifiers changed from: private */
        public void clearFillColor() {
            this.fillColor_ = 0;
        }

        public int getLineTypeValue() {
            return this.lineType_;
        }

        public WXWBLineType getLineType() {
            WXWBLineType forNumber = WXWBLineType.forNumber(this.lineType_);
            return forNumber == null ? WXWBLineType.UNRECOGNIZED : forNumber;
        }

        /* access modifiers changed from: private */
        public void setLineTypeValue(int i) {
            this.lineType_ = i;
        }

        /* access modifiers changed from: private */
        public void setLineType(WXWBLineType wXWBLineType) {
            Objects.requireNonNull(wXWBLineType);
            this.lineType_ = wXWBLineType.getNumber();
        }

        /* access modifiers changed from: private */
        public void clearLineType() {
            this.lineType_ = 0;
        }

        public boolean hasPageConfig() {
            return this.pageConfig_ != null;
        }

        public WXWBPageConfig getPageConfig() {
            WXWBPageConfig wXWBPageConfig = this.pageConfig_;
            return wXWBPageConfig == null ? WXWBPageConfig.getDefaultInstance() : wXWBPageConfig;
        }

        /* access modifiers changed from: private */
        public void setPageConfig(WXWBPageConfig wXWBPageConfig) {
            Objects.requireNonNull(wXWBPageConfig);
            this.pageConfig_ = wXWBPageConfig;
        }

        /* access modifiers changed from: private */
        public void setPageConfig(WXWBPageConfig.Builder builder) {
            this.pageConfig_ = builder.build();
        }

        /* access modifiers changed from: private */
        public void mergePageConfig(WXWBPageConfig wXWBPageConfig) {
            WXWBPageConfig wXWBPageConfig2 = this.pageConfig_;
            if (wXWBPageConfig2 == null || wXWBPageConfig2 == WXWBPageConfig.getDefaultInstance()) {
                this.pageConfig_ = wXWBPageConfig;
            } else {
                this.pageConfig_ = WXWBPageConfig.newBuilder(this.pageConfig_).mergeFrom(wXWBPageConfig).buildPartial();
            }
        }

        /* access modifiers changed from: private */
        public void clearPageConfig() {
            this.pageConfig_ = null;
        }

        public boolean hasRevokeAndRecoverConfig() {
            return this.revokeAndRecoverConfig_ != null;
        }

        public WXWBRevokeAndRecoverConfig getRevokeAndRecoverConfig() {
            WXWBRevokeAndRecoverConfig wXWBRevokeAndRecoverConfig = this.revokeAndRecoverConfig_;
            return wXWBRevokeAndRecoverConfig == null ? WXWBRevokeAndRecoverConfig.getDefaultInstance() : wXWBRevokeAndRecoverConfig;
        }

        /* access modifiers changed from: private */
        public void setRevokeAndRecoverConfig(WXWBRevokeAndRecoverConfig wXWBRevokeAndRecoverConfig) {
            Objects.requireNonNull(wXWBRevokeAndRecoverConfig);
            this.revokeAndRecoverConfig_ = wXWBRevokeAndRecoverConfig;
        }

        /* access modifiers changed from: private */
        public void setRevokeAndRecoverConfig(WXWBRevokeAndRecoverConfig.Builder builder) {
            this.revokeAndRecoverConfig_ = builder.build();
        }

        /* access modifiers changed from: private */
        public void mergeRevokeAndRecoverConfig(WXWBRevokeAndRecoverConfig wXWBRevokeAndRecoverConfig) {
            WXWBRevokeAndRecoverConfig wXWBRevokeAndRecoverConfig2 = this.revokeAndRecoverConfig_;
            if (wXWBRevokeAndRecoverConfig2 == null || wXWBRevokeAndRecoverConfig2 == WXWBRevokeAndRecoverConfig.getDefaultInstance()) {
                this.revokeAndRecoverConfig_ = wXWBRevokeAndRecoverConfig;
            } else {
                this.revokeAndRecoverConfig_ = WXWBRevokeAndRecoverConfig.newBuilder(this.revokeAndRecoverConfig_).mergeFrom(wXWBRevokeAndRecoverConfig).buildPartial();
            }
        }

        /* access modifiers changed from: private */
        public void clearRevokeAndRecoverConfig() {
            this.revokeAndRecoverConfig_ = null;
        }

        public boolean hasChooseConfig() {
            return this.chooseConfig_ != null;
        }

        public WXWBChooseConfig getChooseConfig() {
            WXWBChooseConfig wXWBChooseConfig = this.chooseConfig_;
            return wXWBChooseConfig == null ? WXWBChooseConfig.getDefaultInstance() : wXWBChooseConfig;
        }

        /* access modifiers changed from: private */
        public void setChooseConfig(WXWBChooseConfig wXWBChooseConfig) {
            Objects.requireNonNull(wXWBChooseConfig);
            this.chooseConfig_ = wXWBChooseConfig;
        }

        /* access modifiers changed from: private */
        public void setChooseConfig(WXWBChooseConfig.Builder builder) {
            this.chooseConfig_ = builder.build();
        }

        /* access modifiers changed from: private */
        public void mergeChooseConfig(WXWBChooseConfig wXWBChooseConfig) {
            WXWBChooseConfig wXWBChooseConfig2 = this.chooseConfig_;
            if (wXWBChooseConfig2 == null || wXWBChooseConfig2 == WXWBChooseConfig.getDefaultInstance()) {
                this.chooseConfig_ = wXWBChooseConfig;
            } else {
                this.chooseConfig_ = WXWBChooseConfig.newBuilder(this.chooseConfig_).mergeFrom(wXWBChooseConfig).buildPartial();
            }
        }

        /* access modifiers changed from: private */
        public void clearChooseConfig() {
            this.chooseConfig_ = null;
        }

        public boolean hasRulerConfig() {
            return this.rulerConfig_ != null;
        }

        public WXWBRulerConfig getRulerConfig() {
            WXWBRulerConfig wXWBRulerConfig = this.rulerConfig_;
            return wXWBRulerConfig == null ? WXWBRulerConfig.getDefaultInstance() : wXWBRulerConfig;
        }

        /* access modifiers changed from: private */
        public void setRulerConfig(WXWBRulerConfig wXWBRulerConfig) {
            Objects.requireNonNull(wXWBRulerConfig);
            this.rulerConfig_ = wXWBRulerConfig;
        }

        /* access modifiers changed from: private */
        public void setRulerConfig(WXWBRulerConfig.Builder builder) {
            this.rulerConfig_ = builder.build();
        }

        /* access modifiers changed from: private */
        public void mergeRulerConfig(WXWBRulerConfig wXWBRulerConfig) {
            WXWBRulerConfig wXWBRulerConfig2 = this.rulerConfig_;
            if (wXWBRulerConfig2 == null || wXWBRulerConfig2 == WXWBRulerConfig.getDefaultInstance()) {
                this.rulerConfig_ = wXWBRulerConfig;
            } else {
                this.rulerConfig_ = WXWBRulerConfig.newBuilder(this.rulerConfig_).mergeFrom(wXWBRulerConfig).buildPartial();
            }
        }

        /* access modifiers changed from: private */
        public void clearRulerConfig() {
            this.rulerConfig_ = null;
        }

        public boolean hasCompassesConfig() {
            return this.compassesConfig_ != null;
        }

        public WXWBCompassesConfig getCompassesConfig() {
            WXWBCompassesConfig wXWBCompassesConfig = this.compassesConfig_;
            return wXWBCompassesConfig == null ? WXWBCompassesConfig.getDefaultInstance() : wXWBCompassesConfig;
        }

        /* access modifiers changed from: private */
        public void setCompassesConfig(WXWBCompassesConfig wXWBCompassesConfig) {
            Objects.requireNonNull(wXWBCompassesConfig);
            this.compassesConfig_ = wXWBCompassesConfig;
        }

        /* access modifiers changed from: private */
        public void setCompassesConfig(WXWBCompassesConfig.Builder builder) {
            this.compassesConfig_ = builder.build();
        }

        /* access modifiers changed from: private */
        public void mergeCompassesConfig(WXWBCompassesConfig wXWBCompassesConfig) {
            WXWBCompassesConfig wXWBCompassesConfig2 = this.compassesConfig_;
            if (wXWBCompassesConfig2 == null || wXWBCompassesConfig2 == WXWBCompassesConfig.getDefaultInstance()) {
                this.compassesConfig_ = wXWBCompassesConfig;
            } else {
                this.compassesConfig_ = WXWBCompassesConfig.newBuilder(this.compassesConfig_).mergeFrom(wXWBCompassesConfig).buildPartial();
            }
        }

        /* access modifiers changed from: private */
        public void clearCompassesConfig() {
            this.compassesConfig_ = null;
        }

        public boolean hasRefConfig() {
            return this.refConfig_ != null;
        }

        public WXWBRefConfig getRefConfig() {
            WXWBRefConfig wXWBRefConfig = this.refConfig_;
            return wXWBRefConfig == null ? WXWBRefConfig.getDefaultInstance() : wXWBRefConfig;
        }

        /* access modifiers changed from: private */
        public void setRefConfig(WXWBRefConfig wXWBRefConfig) {
            Objects.requireNonNull(wXWBRefConfig);
            this.refConfig_ = wXWBRefConfig;
        }

        /* access modifiers changed from: private */
        public void setRefConfig(WXWBRefConfig.Builder builder) {
            this.refConfig_ = builder.build();
        }

        /* access modifiers changed from: private */
        public void mergeRefConfig(WXWBRefConfig wXWBRefConfig) {
            WXWBRefConfig wXWBRefConfig2 = this.refConfig_;
            if (wXWBRefConfig2 == null || wXWBRefConfig2 == WXWBRefConfig.getDefaultInstance()) {
                this.refConfig_ = wXWBRefConfig;
            } else {
                this.refConfig_ = WXWBRefConfig.newBuilder(this.refConfig_).mergeFrom(wXWBRefConfig).buildPartial();
            }
        }

        /* access modifiers changed from: private */
        public void clearRefConfig() {
            this.refConfig_ = null;
        }

        public boolean hasUserInfo() {
            return this.userInfo_ != null;
        }

        public WXWBUserInfo getUserInfo() {
            WXWBUserInfo wXWBUserInfo = this.userInfo_;
            return wXWBUserInfo == null ? WXWBUserInfo.getDefaultInstance() : wXWBUserInfo;
        }

        /* access modifiers changed from: private */
        public void setUserInfo(WXWBUserInfo wXWBUserInfo) {
            Objects.requireNonNull(wXWBUserInfo);
            this.userInfo_ = wXWBUserInfo;
        }

        /* access modifiers changed from: private */
        public void setUserInfo(WXWBUserInfo.Builder builder) {
            this.userInfo_ = builder.build();
        }

        /* access modifiers changed from: private */
        public void mergeUserInfo(WXWBUserInfo wXWBUserInfo) {
            WXWBUserInfo wXWBUserInfo2 = this.userInfo_;
            if (wXWBUserInfo2 == null || wXWBUserInfo2 == WXWBUserInfo.getDefaultInstance()) {
                this.userInfo_ = wXWBUserInfo;
            } else {
                this.userInfo_ = WXWBUserInfo.newBuilder(this.userInfo_).mergeFrom(wXWBUserInfo).buildPartial();
            }
        }

        /* access modifiers changed from: private */
        public void clearUserInfo() {
            this.userInfo_ = null;
        }

        public String getUid() {
            return this.uid_;
        }

        public ByteString getUidBytes() {
            return ByteString.copyFromUtf8(this.uid_);
        }

        /* access modifiers changed from: private */
        public void setUid(String str) {
            Objects.requireNonNull(str);
            this.uid_ = str;
        }

        /* access modifiers changed from: private */
        public void clearUid() {
            this.uid_ = getDefaultInstance().getUid();
        }

        /* access modifiers changed from: private */
        public void setUidBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            checkByteStringIsUtf8(byteString);
            this.uid_ = byteString.toStringUtf8();
        }

        public boolean hasCanvasInfo() {
            return this.canvasInfo_ != null;
        }

        public WXWBCanvasInfo getCanvasInfo() {
            WXWBCanvasInfo wXWBCanvasInfo = this.canvasInfo_;
            return wXWBCanvasInfo == null ? WXWBCanvasInfo.getDefaultInstance() : wXWBCanvasInfo;
        }

        /* access modifiers changed from: private */
        public void setCanvasInfo(WXWBCanvasInfo wXWBCanvasInfo) {
            Objects.requireNonNull(wXWBCanvasInfo);
            this.canvasInfo_ = wXWBCanvasInfo;
        }

        /* access modifiers changed from: private */
        public void setCanvasInfo(WXWBCanvasInfo.Builder builder) {
            this.canvasInfo_ = builder.build();
        }

        /* access modifiers changed from: private */
        public void mergeCanvasInfo(WXWBCanvasInfo wXWBCanvasInfo) {
            WXWBCanvasInfo wXWBCanvasInfo2 = this.canvasInfo_;
            if (wXWBCanvasInfo2 == null || wXWBCanvasInfo2 == WXWBCanvasInfo.getDefaultInstance()) {
                this.canvasInfo_ = wXWBCanvasInfo;
            } else {
                this.canvasInfo_ = WXWBCanvasInfo.newBuilder(this.canvasInfo_).mergeFrom(wXWBCanvasInfo).buildPartial();
            }
        }

        /* access modifiers changed from: private */
        public void clearCanvasInfo() {
            this.canvasInfo_ = null;
        }

        public boolean hasSelectConfig() {
            return this.selectConfig_ != null;
        }

        public WXWBSelectAreaConfig getSelectConfig() {
            WXWBSelectAreaConfig wXWBSelectAreaConfig = this.selectConfig_;
            return wXWBSelectAreaConfig == null ? WXWBSelectAreaConfig.getDefaultInstance() : wXWBSelectAreaConfig;
        }

        /* access modifiers changed from: private */
        public void setSelectConfig(WXWBSelectAreaConfig wXWBSelectAreaConfig) {
            Objects.requireNonNull(wXWBSelectAreaConfig);
            this.selectConfig_ = wXWBSelectAreaConfig;
        }

        /* access modifiers changed from: private */
        public void setSelectConfig(WXWBSelectAreaConfig.Builder builder) {
            this.selectConfig_ = builder.build();
        }

        /* access modifiers changed from: private */
        public void mergeSelectConfig(WXWBSelectAreaConfig wXWBSelectAreaConfig) {
            WXWBSelectAreaConfig wXWBSelectAreaConfig2 = this.selectConfig_;
            if (wXWBSelectAreaConfig2 == null || wXWBSelectAreaConfig2 == WXWBSelectAreaConfig.getDefaultInstance()) {
                this.selectConfig_ = wXWBSelectAreaConfig;
            } else {
                this.selectConfig_ = WXWBSelectAreaConfig.newBuilder(this.selectConfig_).mergeFrom(wXWBSelectAreaConfig).buildPartial();
            }
        }

        /* access modifiers changed from: private */
        public void clearSelectConfig() {
            this.selectConfig_ = null;
        }

        public boolean hasMyBusiness() {
            return this.myBusiness_ != null;
        }

        public Any getMyBusiness() {
            Any any = this.myBusiness_;
            return any == null ? Any.getDefaultInstance() : any;
        }

        /* access modifiers changed from: private */
        public void setMyBusiness(Any any) {
            Objects.requireNonNull(any);
            this.myBusiness_ = any;
        }

        /* access modifiers changed from: private */
        public void setMyBusiness(Any.Builder builder) {
            this.myBusiness_ = builder.build();
        }

        /* access modifiers changed from: private */
        public void mergeMyBusiness(Any any) {
            Any any2 = this.myBusiness_;
            if (any2 == null || any2 == Any.getDefaultInstance()) {
                this.myBusiness_ = any;
            } else {
                this.myBusiness_ = Any.newBuilder(this.myBusiness_).mergeFrom(any).buildPartial();
            }
        }

        /* access modifiers changed from: private */
        public void clearMyBusiness() {
            this.myBusiness_ = null;
        }

        public int getBusinessType() {
            return this.businessType_;
        }

        /* access modifiers changed from: private */
        public void setBusinessType(int i) {
            this.businessType_ = i;
        }

        /* access modifiers changed from: private */
        public void clearBusinessType() {
            this.businessType_ = 0;
        }

        public boolean hasCursorPosition() {
            return this.cursorPosition_ != null;
        }

        public WXWBPoint getCursorPosition() {
            WXWBPoint wXWBPoint = this.cursorPosition_;
            return wXWBPoint == null ? WXWBPoint.getDefaultInstance() : wXWBPoint;
        }

        /* access modifiers changed from: private */
        public void setCursorPosition(WXWBPoint wXWBPoint) {
            Objects.requireNonNull(wXWBPoint);
            this.cursorPosition_ = wXWBPoint;
        }

        /* access modifiers changed from: private */
        public void setCursorPosition(WXWBPoint.Builder builder) {
            this.cursorPosition_ = builder.build();
        }

        /* access modifiers changed from: private */
        public void mergeCursorPosition(WXWBPoint wXWBPoint) {
            WXWBPoint wXWBPoint2 = this.cursorPosition_;
            if (wXWBPoint2 == null || wXWBPoint2 == WXWBPoint.getDefaultInstance()) {
                this.cursorPosition_ = wXWBPoint;
            } else {
                this.cursorPosition_ = WXWBPoint.newBuilder(this.cursorPosition_).mergeFrom(wXWBPoint).buildPartial();
            }
        }

        /* access modifiers changed from: private */
        public void clearCursorPosition() {
            this.cursorPosition_ = null;
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (this.type_ != WXWBMessageType.WXWBMessageTypeRecover.getNumber()) {
                codedOutputStream.writeEnum(1, this.type_);
            }
            if (this.pointType_ != WXTPointType.WXWBPointTypePen.getNumber()) {
                codedOutputStream.writeEnum(2, this.pointType_);
            }
            if (!this.courseId_.isEmpty()) {
                codedOutputStream.writeString(3, getCourseId());
            }
            if (!this.pageId_.isEmpty()) {
                codedOutputStream.writeString(4, getPageId());
            }
            long j = this.lineIndex_;
            if (j != 0) {
                codedOutputStream.writeUInt64(5, j);
            }
            for (int i = 0; i < this.pointList_.size(); i++) {
                codedOutputStream.writeMessage(7, (MessageLite) this.pointList_.get(i));
            }
            int i2 = this.width_;
            if (i2 != 0) {
                codedOutputStream.writeInt32(8, i2);
            }
            int i3 = this.height_;
            if (i3 != 0) {
                codedOutputStream.writeInt32(9, i3);
            }
            long j2 = this.msgId_;
            if (j2 != 0) {
                codedOutputStream.writeUInt64(11, j2);
            }
            float f = this.lineWidth_;
            if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(12, f);
            }
            int i4 = this.strokeColor_;
            if (i4 != 0) {
                codedOutputStream.writeUInt32(13, i4);
            }
            long j3 = this.dataCreateTimestamp_;
            if (j3 != 0) {
                codedOutputStream.writeUInt64(14, j3);
            }
            float f2 = this.rotation_;
            if (f2 != CropImageView.DEFAULT_ASPECT_RATIO) {
                codedOutputStream.writeFloat(15, f2);
            }
            int i5 = this.fillColor_;
            if (i5 != 0) {
                codedOutputStream.writeUInt32(16, i5);
            }
            if (this.lineType_ != WXWBLineType.WXWBLineTypeSolid.getNumber()) {
                codedOutputStream.writeEnum(17, this.lineType_);
            }
            if (this.pageConfig_ != null) {
                codedOutputStream.writeMessage(18, getPageConfig());
            }
            if (this.revokeAndRecoverConfig_ != null) {
                codedOutputStream.writeMessage(19, getRevokeAndRecoverConfig());
            }
            if (this.chooseConfig_ != null) {
                codedOutputStream.writeMessage(20, getChooseConfig());
            }
            if (this.rulerConfig_ != null) {
                codedOutputStream.writeMessage(21, getRulerConfig());
            }
            if (this.compassesConfig_ != null) {
                codedOutputStream.writeMessage(22, getCompassesConfig());
            }
            if (this.refConfig_ != null) {
                codedOutputStream.writeMessage(23, getRefConfig());
            }
            if (this.userInfo_ != null) {
                codedOutputStream.writeMessage(27, getUserInfo());
            }
            if (!this.uid_.isEmpty()) {
                codedOutputStream.writeString(30, getUid());
            }
            if (this.canvasInfo_ != null) {
                codedOutputStream.writeMessage(31, getCanvasInfo());
            }
            if (this.selectConfig_ != null) {
                codedOutputStream.writeMessage(32, getSelectConfig());
            }
            if (this.cursorPosition_ != null) {
                codedOutputStream.writeMessage(33, getCursorPosition());
            }
            if (this.myBusiness_ != null) {
                codedOutputStream.writeMessage(1000, getMyBusiness());
            }
            int i6 = this.businessType_;
            if (i6 != 0) {
                codedOutputStream.writeUInt32(1001, i6);
            }
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeEnumSize = this.type_ != WXWBMessageType.WXWBMessageTypeRecover.getNumber() ? CodedOutputStream.computeEnumSize(1, this.type_) + 0 : 0;
            if (this.pointType_ != WXTPointType.WXWBPointTypePen.getNumber()) {
                computeEnumSize += CodedOutputStream.computeEnumSize(2, this.pointType_);
            }
            if (!this.courseId_.isEmpty()) {
                computeEnumSize += CodedOutputStream.computeStringSize(3, getCourseId());
            }
            if (!this.pageId_.isEmpty()) {
                computeEnumSize += CodedOutputStream.computeStringSize(4, getPageId());
            }
            long j = this.lineIndex_;
            if (j != 0) {
                computeEnumSize += CodedOutputStream.computeUInt64Size(5, j);
            }
            for (int i2 = 0; i2 < this.pointList_.size(); i2++) {
                computeEnumSize += CodedOutputStream.computeMessageSize(7, (MessageLite) this.pointList_.get(i2));
            }
            int i3 = this.width_;
            if (i3 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(8, i3);
            }
            int i4 = this.height_;
            if (i4 != 0) {
                computeEnumSize += CodedOutputStream.computeInt32Size(9, i4);
            }
            long j2 = this.msgId_;
            if (j2 != 0) {
                computeEnumSize += CodedOutputStream.computeUInt64Size(11, j2);
            }
            float f = this.lineWidth_;
            if (f != CropImageView.DEFAULT_ASPECT_RATIO) {
                computeEnumSize += CodedOutputStream.computeFloatSize(12, f);
            }
            int i5 = this.strokeColor_;
            if (i5 != 0) {
                computeEnumSize += CodedOutputStream.computeUInt32Size(13, i5);
            }
            long j3 = this.dataCreateTimestamp_;
            if (j3 != 0) {
                computeEnumSize += CodedOutputStream.computeUInt64Size(14, j3);
            }
            float f2 = this.rotation_;
            if (f2 != CropImageView.DEFAULT_ASPECT_RATIO) {
                computeEnumSize += CodedOutputStream.computeFloatSize(15, f2);
            }
            int i6 = this.fillColor_;
            if (i6 != 0) {
                computeEnumSize += CodedOutputStream.computeUInt32Size(16, i6);
            }
            if (this.lineType_ != WXWBLineType.WXWBLineTypeSolid.getNumber()) {
                computeEnumSize += CodedOutputStream.computeEnumSize(17, this.lineType_);
            }
            if (this.pageConfig_ != null) {
                computeEnumSize += CodedOutputStream.computeMessageSize(18, getPageConfig());
            }
            if (this.revokeAndRecoverConfig_ != null) {
                computeEnumSize += CodedOutputStream.computeMessageSize(19, getRevokeAndRecoverConfig());
            }
            if (this.chooseConfig_ != null) {
                computeEnumSize += CodedOutputStream.computeMessageSize(20, getChooseConfig());
            }
            if (this.rulerConfig_ != null) {
                computeEnumSize += CodedOutputStream.computeMessageSize(21, getRulerConfig());
            }
            if (this.compassesConfig_ != null) {
                computeEnumSize += CodedOutputStream.computeMessageSize(22, getCompassesConfig());
            }
            if (this.refConfig_ != null) {
                computeEnumSize += CodedOutputStream.computeMessageSize(23, getRefConfig());
            }
            if (this.userInfo_ != null) {
                computeEnumSize += CodedOutputStream.computeMessageSize(27, getUserInfo());
            }
            if (!this.uid_.isEmpty()) {
                computeEnumSize += CodedOutputStream.computeStringSize(30, getUid());
            }
            if (this.canvasInfo_ != null) {
                computeEnumSize += CodedOutputStream.computeMessageSize(31, getCanvasInfo());
            }
            if (this.selectConfig_ != null) {
                computeEnumSize += CodedOutputStream.computeMessageSize(32, getSelectConfig());
            }
            if (this.cursorPosition_ != null) {
                computeEnumSize += CodedOutputStream.computeMessageSize(33, getCursorPosition());
            }
            if (this.myBusiness_ != null) {
                computeEnumSize += CodedOutputStream.computeMessageSize(1000, getMyBusiness());
            }
            int i7 = this.businessType_;
            if (i7 != 0) {
                computeEnumSize += CodedOutputStream.computeUInt32Size(1001, i7);
            }
            this.memoizedSerializedSize = computeEnumSize;
            return computeEnumSize;
        }

        public static WXWBTCPPacketData parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static WXWBTCPPacketData parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static WXWBTCPPacketData parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static WXWBTCPPacketData parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static WXWBTCPPacketData parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WXWBTCPPacketData parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WXWBTCPPacketData parseDelimitedFrom(InputStream inputStream) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static WXWBTCPPacketData parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static WXWBTCPPacketData parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static WXWBTCPPacketData parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WXWBTCPPacketData wXWBTCPPacketData) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(wXWBTCPPacketData);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<WXWBTCPPacketData, Builder> implements WXWBTCPPacketDataOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(WXWBTCPPacketData.DEFAULT_INSTANCE);
            }

            public int getTypeValue() {
                return this.instance.getTypeValue();
            }

            public Builder setTypeValue(int i) {
                copyOnWrite();
                this.instance.setTypeValue(i);
                return this;
            }

            public WXWBMessageType getType() {
                return this.instance.getType();
            }

            public Builder setType(WXWBMessageType wXWBMessageType) {
                copyOnWrite();
                this.instance.setType(wXWBMessageType);
                return this;
            }

            public Builder clearType() {
                copyOnWrite();
                this.instance.clearType();
                return this;
            }

            public int getPointTypeValue() {
                return this.instance.getPointTypeValue();
            }

            public Builder setPointTypeValue(int i) {
                copyOnWrite();
                this.instance.setPointTypeValue(i);
                return this;
            }

            public WXTPointType getPointType() {
                return this.instance.getPointType();
            }

            public Builder setPointType(WXTPointType wXTPointType) {
                copyOnWrite();
                this.instance.setPointType(wXTPointType);
                return this;
            }

            public Builder clearPointType() {
                copyOnWrite();
                this.instance.clearPointType();
                return this;
            }

            public String getCourseId() {
                return this.instance.getCourseId();
            }

            public ByteString getCourseIdBytes() {
                return this.instance.getCourseIdBytes();
            }

            public Builder setCourseId(String str) {
                copyOnWrite();
                this.instance.setCourseId(str);
                return this;
            }

            public Builder clearCourseId() {
                copyOnWrite();
                this.instance.clearCourseId();
                return this;
            }

            public Builder setCourseIdBytes(ByteString byteString) {
                copyOnWrite();
                this.instance.setCourseIdBytes(byteString);
                return this;
            }

            public String getPageId() {
                return this.instance.getPageId();
            }

            public ByteString getPageIdBytes() {
                return this.instance.getPageIdBytes();
            }

            public Builder setPageId(String str) {
                copyOnWrite();
                this.instance.setPageId(str);
                return this;
            }

            public Builder clearPageId() {
                copyOnWrite();
                this.instance.clearPageId();
                return this;
            }

            public Builder setPageIdBytes(ByteString byteString) {
                copyOnWrite();
                this.instance.setPageIdBytes(byteString);
                return this;
            }

            public long getLineIndex() {
                return this.instance.getLineIndex();
            }

            public Builder setLineIndex(long j) {
                copyOnWrite();
                this.instance.setLineIndex(j);
                return this;
            }

            public Builder clearLineIndex() {
                copyOnWrite();
                this.instance.clearLineIndex();
                return this;
            }

            public List<WXWBPoint> getPointListList() {
                return Collections.unmodifiableList(this.instance.getPointListList());
            }

            public int getPointListCount() {
                return this.instance.getPointListCount();
            }

            public WXWBPoint getPointList(int i) {
                return this.instance.getPointList(i);
            }

            public Builder setPointList(int i, WXWBPoint wXWBPoint) {
                copyOnWrite();
                this.instance.setPointList(i, wXWBPoint);
                return this;
            }

            public Builder setPointList(int i, WXWBPoint.Builder builder) {
                copyOnWrite();
                this.instance.setPointList(i, builder);
                return this;
            }

            public Builder addPointList(WXWBPoint wXWBPoint) {
                copyOnWrite();
                this.instance.addPointList(wXWBPoint);
                return this;
            }

            public Builder addPointList(int i, WXWBPoint wXWBPoint) {
                copyOnWrite();
                this.instance.addPointList(i, wXWBPoint);
                return this;
            }

            public Builder addPointList(WXWBPoint.Builder builder) {
                copyOnWrite();
                this.instance.addPointList(builder);
                return this;
            }

            public Builder addPointList(int i, WXWBPoint.Builder builder) {
                copyOnWrite();
                this.instance.addPointList(i, builder);
                return this;
            }

            public Builder addAllPointList(Iterable<? extends WXWBPoint> iterable) {
                copyOnWrite();
                this.instance.addAllPointList(iterable);
                return this;
            }

            public Builder clearPointList() {
                copyOnWrite();
                this.instance.clearPointList();
                return this;
            }

            public Builder removePointList(int i) {
                copyOnWrite();
                this.instance.removePointList(i);
                return this;
            }

            public int getWidth() {
                return this.instance.getWidth();
            }

            public Builder setWidth(int i) {
                copyOnWrite();
                this.instance.setWidth(i);
                return this;
            }

            public Builder clearWidth() {
                copyOnWrite();
                this.instance.clearWidth();
                return this;
            }

            public int getHeight() {
                return this.instance.getHeight();
            }

            public Builder setHeight(int i) {
                copyOnWrite();
                this.instance.setHeight(i);
                return this;
            }

            public Builder clearHeight() {
                copyOnWrite();
                this.instance.clearHeight();
                return this;
            }

            public long getMsgId() {
                return this.instance.getMsgId();
            }

            public Builder setMsgId(long j) {
                copyOnWrite();
                this.instance.setMsgId(j);
                return this;
            }

            public Builder clearMsgId() {
                copyOnWrite();
                this.instance.clearMsgId();
                return this;
            }

            public float getLineWidth() {
                return this.instance.getLineWidth();
            }

            public Builder setLineWidth(float f) {
                copyOnWrite();
                this.instance.setLineWidth(f);
                return this;
            }

            public Builder clearLineWidth() {
                copyOnWrite();
                this.instance.clearLineWidth();
                return this;
            }

            public int getStrokeColor() {
                return this.instance.getStrokeColor();
            }

            public Builder setStrokeColor(int i) {
                copyOnWrite();
                this.instance.setStrokeColor(i);
                return this;
            }

            public Builder clearStrokeColor() {
                copyOnWrite();
                this.instance.clearStrokeColor();
                return this;
            }

            public long getDataCreateTimestamp() {
                return this.instance.getDataCreateTimestamp();
            }

            public Builder setDataCreateTimestamp(long j) {
                copyOnWrite();
                this.instance.setDataCreateTimestamp(j);
                return this;
            }

            public Builder clearDataCreateTimestamp() {
                copyOnWrite();
                this.instance.clearDataCreateTimestamp();
                return this;
            }

            public float getRotation() {
                return this.instance.getRotation();
            }

            public Builder setRotation(float f) {
                copyOnWrite();
                this.instance.setRotation(f);
                return this;
            }

            public Builder clearRotation() {
                copyOnWrite();
                this.instance.clearRotation();
                return this;
            }

            public int getFillColor() {
                return this.instance.getFillColor();
            }

            public Builder setFillColor(int i) {
                copyOnWrite();
                this.instance.setFillColor(i);
                return this;
            }

            public Builder clearFillColor() {
                copyOnWrite();
                this.instance.clearFillColor();
                return this;
            }

            public int getLineTypeValue() {
                return this.instance.getLineTypeValue();
            }

            public Builder setLineTypeValue(int i) {
                copyOnWrite();
                this.instance.setLineTypeValue(i);
                return this;
            }

            public WXWBLineType getLineType() {
                return this.instance.getLineType();
            }

            public Builder setLineType(WXWBLineType wXWBLineType) {
                copyOnWrite();
                this.instance.setLineType(wXWBLineType);
                return this;
            }

            public Builder clearLineType() {
                copyOnWrite();
                this.instance.clearLineType();
                return this;
            }

            public boolean hasPageConfig() {
                return this.instance.hasPageConfig();
            }

            public WXWBPageConfig getPageConfig() {
                return this.instance.getPageConfig();
            }

            public Builder setPageConfig(WXWBPageConfig wXWBPageConfig) {
                copyOnWrite();
                this.instance.setPageConfig(wXWBPageConfig);
                return this;
            }

            public Builder setPageConfig(WXWBPageConfig.Builder builder) {
                copyOnWrite();
                this.instance.setPageConfig(builder);
                return this;
            }

            public Builder mergePageConfig(WXWBPageConfig wXWBPageConfig) {
                copyOnWrite();
                this.instance.mergePageConfig(wXWBPageConfig);
                return this;
            }

            public Builder clearPageConfig() {
                copyOnWrite();
                this.instance.clearPageConfig();
                return this;
            }

            public boolean hasRevokeAndRecoverConfig() {
                return this.instance.hasRevokeAndRecoverConfig();
            }

            public WXWBRevokeAndRecoverConfig getRevokeAndRecoverConfig() {
                return this.instance.getRevokeAndRecoverConfig();
            }

            public Builder setRevokeAndRecoverConfig(WXWBRevokeAndRecoverConfig wXWBRevokeAndRecoverConfig) {
                copyOnWrite();
                this.instance.setRevokeAndRecoverConfig(wXWBRevokeAndRecoverConfig);
                return this;
            }

            public Builder setRevokeAndRecoverConfig(WXWBRevokeAndRecoverConfig.Builder builder) {
                copyOnWrite();
                this.instance.setRevokeAndRecoverConfig(builder);
                return this;
            }

            public Builder mergeRevokeAndRecoverConfig(WXWBRevokeAndRecoverConfig wXWBRevokeAndRecoverConfig) {
                copyOnWrite();
                this.instance.mergeRevokeAndRecoverConfig(wXWBRevokeAndRecoverConfig);
                return this;
            }

            public Builder clearRevokeAndRecoverConfig() {
                copyOnWrite();
                this.instance.clearRevokeAndRecoverConfig();
                return this;
            }

            public boolean hasChooseConfig() {
                return this.instance.hasChooseConfig();
            }

            public WXWBChooseConfig getChooseConfig() {
                return this.instance.getChooseConfig();
            }

            public Builder setChooseConfig(WXWBChooseConfig wXWBChooseConfig) {
                copyOnWrite();
                this.instance.setChooseConfig(wXWBChooseConfig);
                return this;
            }

            public Builder setChooseConfig(WXWBChooseConfig.Builder builder) {
                copyOnWrite();
                this.instance.setChooseConfig(builder);
                return this;
            }

            public Builder mergeChooseConfig(WXWBChooseConfig wXWBChooseConfig) {
                copyOnWrite();
                this.instance.mergeChooseConfig(wXWBChooseConfig);
                return this;
            }

            public Builder clearChooseConfig() {
                copyOnWrite();
                this.instance.clearChooseConfig();
                return this;
            }

            public boolean hasRulerConfig() {
                return this.instance.hasRulerConfig();
            }

            public WXWBRulerConfig getRulerConfig() {
                return this.instance.getRulerConfig();
            }

            public Builder setRulerConfig(WXWBRulerConfig wXWBRulerConfig) {
                copyOnWrite();
                this.instance.setRulerConfig(wXWBRulerConfig);
                return this;
            }

            public Builder setRulerConfig(WXWBRulerConfig.Builder builder) {
                copyOnWrite();
                this.instance.setRulerConfig(builder);
                return this;
            }

            public Builder mergeRulerConfig(WXWBRulerConfig wXWBRulerConfig) {
                copyOnWrite();
                this.instance.mergeRulerConfig(wXWBRulerConfig);
                return this;
            }

            public Builder clearRulerConfig() {
                copyOnWrite();
                this.instance.clearRulerConfig();
                return this;
            }

            public boolean hasCompassesConfig() {
                return this.instance.hasCompassesConfig();
            }

            public WXWBCompassesConfig getCompassesConfig() {
                return this.instance.getCompassesConfig();
            }

            public Builder setCompassesConfig(WXWBCompassesConfig wXWBCompassesConfig) {
                copyOnWrite();
                this.instance.setCompassesConfig(wXWBCompassesConfig);
                return this;
            }

            public Builder setCompassesConfig(WXWBCompassesConfig.Builder builder) {
                copyOnWrite();
                this.instance.setCompassesConfig(builder);
                return this;
            }

            public Builder mergeCompassesConfig(WXWBCompassesConfig wXWBCompassesConfig) {
                copyOnWrite();
                this.instance.mergeCompassesConfig(wXWBCompassesConfig);
                return this;
            }

            public Builder clearCompassesConfig() {
                copyOnWrite();
                this.instance.clearCompassesConfig();
                return this;
            }

            public boolean hasRefConfig() {
                return this.instance.hasRefConfig();
            }

            public WXWBRefConfig getRefConfig() {
                return this.instance.getRefConfig();
            }

            public Builder setRefConfig(WXWBRefConfig wXWBRefConfig) {
                copyOnWrite();
                this.instance.setRefConfig(wXWBRefConfig);
                return this;
            }

            public Builder setRefConfig(WXWBRefConfig.Builder builder) {
                copyOnWrite();
                this.instance.setRefConfig(builder);
                return this;
            }

            public Builder mergeRefConfig(WXWBRefConfig wXWBRefConfig) {
                copyOnWrite();
                this.instance.mergeRefConfig(wXWBRefConfig);
                return this;
            }

            public Builder clearRefConfig() {
                copyOnWrite();
                this.instance.clearRefConfig();
                return this;
            }

            public boolean hasUserInfo() {
                return this.instance.hasUserInfo();
            }

            public WXWBUserInfo getUserInfo() {
                return this.instance.getUserInfo();
            }

            public Builder setUserInfo(WXWBUserInfo wXWBUserInfo) {
                copyOnWrite();
                this.instance.setUserInfo(wXWBUserInfo);
                return this;
            }

            public Builder setUserInfo(WXWBUserInfo.Builder builder) {
                copyOnWrite();
                this.instance.setUserInfo(builder);
                return this;
            }

            public Builder mergeUserInfo(WXWBUserInfo wXWBUserInfo) {
                copyOnWrite();
                this.instance.mergeUserInfo(wXWBUserInfo);
                return this;
            }

            public Builder clearUserInfo() {
                copyOnWrite();
                this.instance.clearUserInfo();
                return this;
            }

            public String getUid() {
                return this.instance.getUid();
            }

            public ByteString getUidBytes() {
                return this.instance.getUidBytes();
            }

            public Builder setUid(String str) {
                copyOnWrite();
                this.instance.setUid(str);
                return this;
            }

            public Builder clearUid() {
                copyOnWrite();
                this.instance.clearUid();
                return this;
            }

            public Builder setUidBytes(ByteString byteString) {
                copyOnWrite();
                this.instance.setUidBytes(byteString);
                return this;
            }

            public boolean hasCanvasInfo() {
                return this.instance.hasCanvasInfo();
            }

            public WXWBCanvasInfo getCanvasInfo() {
                return this.instance.getCanvasInfo();
            }

            public Builder setCanvasInfo(WXWBCanvasInfo wXWBCanvasInfo) {
                copyOnWrite();
                this.instance.setCanvasInfo(wXWBCanvasInfo);
                return this;
            }

            public Builder setCanvasInfo(WXWBCanvasInfo.Builder builder) {
                copyOnWrite();
                this.instance.setCanvasInfo(builder);
                return this;
            }

            public Builder mergeCanvasInfo(WXWBCanvasInfo wXWBCanvasInfo) {
                copyOnWrite();
                this.instance.mergeCanvasInfo(wXWBCanvasInfo);
                return this;
            }

            public Builder clearCanvasInfo() {
                copyOnWrite();
                this.instance.clearCanvasInfo();
                return this;
            }

            public boolean hasSelectConfig() {
                return this.instance.hasSelectConfig();
            }

            public WXWBSelectAreaConfig getSelectConfig() {
                return this.instance.getSelectConfig();
            }

            public Builder setSelectConfig(WXWBSelectAreaConfig wXWBSelectAreaConfig) {
                copyOnWrite();
                this.instance.setSelectConfig(wXWBSelectAreaConfig);
                return this;
            }

            public Builder setSelectConfig(WXWBSelectAreaConfig.Builder builder) {
                copyOnWrite();
                this.instance.setSelectConfig(builder);
                return this;
            }

            public Builder mergeSelectConfig(WXWBSelectAreaConfig wXWBSelectAreaConfig) {
                copyOnWrite();
                this.instance.mergeSelectConfig(wXWBSelectAreaConfig);
                return this;
            }

            public Builder clearSelectConfig() {
                copyOnWrite();
                this.instance.clearSelectConfig();
                return this;
            }

            public boolean hasMyBusiness() {
                return this.instance.hasMyBusiness();
            }

            public Any getMyBusiness() {
                return this.instance.getMyBusiness();
            }

            public Builder setMyBusiness(Any any) {
                copyOnWrite();
                this.instance.setMyBusiness(any);
                return this;
            }

            public Builder setMyBusiness(Any.Builder builder) {
                copyOnWrite();
                this.instance.setMyBusiness(builder);
                return this;
            }

            public Builder mergeMyBusiness(Any any) {
                copyOnWrite();
                this.instance.mergeMyBusiness(any);
                return this;
            }

            public Builder clearMyBusiness() {
                copyOnWrite();
                this.instance.clearMyBusiness();
                return this;
            }

            public int getBusinessType() {
                return this.instance.getBusinessType();
            }

            public Builder setBusinessType(int i) {
                copyOnWrite();
                this.instance.setBusinessType(i);
                return this;
            }

            public Builder clearBusinessType() {
                copyOnWrite();
                this.instance.clearBusinessType();
                return this;
            }

            public boolean hasCursorPosition() {
                return this.instance.hasCursorPosition();
            }

            public WXWBPoint getCursorPosition() {
                return this.instance.getCursorPosition();
            }

            public Builder setCursorPosition(WXWBPoint wXWBPoint) {
                copyOnWrite();
                this.instance.setCursorPosition(wXWBPoint);
                return this;
            }

            public Builder setCursorPosition(WXWBPoint.Builder builder) {
                copyOnWrite();
                this.instance.setCursorPosition(builder);
                return this;
            }

            public Builder mergeCursorPosition(WXWBPoint wXWBPoint) {
                copyOnWrite();
                this.instance.mergeCursorPosition(wXWBPoint);
                return this;
            }

            public Builder clearCursorPosition() {
                copyOnWrite();
                this.instance.clearCursorPosition();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new WXWBTCPPacketData();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    this.pointList_.makeImmutable();
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = (GeneratedMessageLite.Visitor) obj;
                    WXWBTCPPacketData wXWBTCPPacketData = (WXWBTCPPacketData) obj2;
                    int i = this.type_;
                    boolean z2 = i != 0;
                    int i2 = wXWBTCPPacketData.type_;
                    this.type_ = mergeFromVisitor.visitInt(z2, i, i2 != 0, i2);
                    int i3 = this.pointType_;
                    boolean z3 = i3 != 0;
                    int i4 = wXWBTCPPacketData.pointType_;
                    this.pointType_ = mergeFromVisitor.visitInt(z3, i3, i4 != 0, i4);
                    this.courseId_ = mergeFromVisitor.visitString(!this.courseId_.isEmpty(), this.courseId_, !wXWBTCPPacketData.courseId_.isEmpty(), wXWBTCPPacketData.courseId_);
                    this.pageId_ = mergeFromVisitor.visitString(!this.pageId_.isEmpty(), this.pageId_, !wXWBTCPPacketData.pageId_.isEmpty(), wXWBTCPPacketData.pageId_);
                    long j = this.lineIndex_;
                    boolean z4 = j != 0;
                    long j2 = wXWBTCPPacketData.lineIndex_;
                    this.lineIndex_ = mergeFromVisitor.visitLong(z4, j, j2 != 0, j2);
                    this.pointList_ = mergeFromVisitor.visitList(this.pointList_, wXWBTCPPacketData.pointList_);
                    int i5 = this.width_;
                    boolean z5 = i5 != 0;
                    int i6 = wXWBTCPPacketData.width_;
                    this.width_ = mergeFromVisitor.visitInt(z5, i5, i6 != 0, i6);
                    int i7 = this.height_;
                    boolean z6 = i7 != 0;
                    int i8 = wXWBTCPPacketData.height_;
                    this.height_ = mergeFromVisitor.visitInt(z6, i7, i8 != 0, i8);
                    long j3 = this.msgId_;
                    boolean z7 = j3 != 0;
                    long j4 = wXWBTCPPacketData.msgId_;
                    this.msgId_ = mergeFromVisitor.visitLong(z7, j3, j4 != 0, j4);
                    float f = this.lineWidth_;
                    boolean z8 = f != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f2 = wXWBTCPPacketData.lineWidth_;
                    this.lineWidth_ = mergeFromVisitor.visitFloat(z8, f, f2 != CropImageView.DEFAULT_ASPECT_RATIO, f2);
                    int i9 = this.strokeColor_;
                    boolean z9 = i9 != 0;
                    int i10 = wXWBTCPPacketData.strokeColor_;
                    this.strokeColor_ = mergeFromVisitor.visitInt(z9, i9, i10 != 0, i10);
                    long j5 = this.dataCreateTimestamp_;
                    boolean z10 = j5 != 0;
                    long j6 = wXWBTCPPacketData.dataCreateTimestamp_;
                    this.dataCreateTimestamp_ = mergeFromVisitor.visitLong(z10, j5, j6 != 0, j6);
                    float f3 = this.rotation_;
                    boolean z11 = f3 != CropImageView.DEFAULT_ASPECT_RATIO;
                    float f4 = wXWBTCPPacketData.rotation_;
                    this.rotation_ = mergeFromVisitor.visitFloat(z11, f3, f4 != CropImageView.DEFAULT_ASPECT_RATIO, f4);
                    int i11 = this.fillColor_;
                    boolean z12 = i11 != 0;
                    int i12 = wXWBTCPPacketData.fillColor_;
                    this.fillColor_ = mergeFromVisitor.visitInt(z12, i11, i12 != 0, i12);
                    int i13 = this.lineType_;
                    boolean z13 = i13 != 0;
                    int i14 = wXWBTCPPacketData.lineType_;
                    this.lineType_ = mergeFromVisitor.visitInt(z13, i13, i14 != 0, i14);
                    this.pageConfig_ = mergeFromVisitor.visitMessage(this.pageConfig_, wXWBTCPPacketData.pageConfig_);
                    this.revokeAndRecoverConfig_ = mergeFromVisitor.visitMessage(this.revokeAndRecoverConfig_, wXWBTCPPacketData.revokeAndRecoverConfig_);
                    this.chooseConfig_ = mergeFromVisitor.visitMessage(this.chooseConfig_, wXWBTCPPacketData.chooseConfig_);
                    this.rulerConfig_ = mergeFromVisitor.visitMessage(this.rulerConfig_, wXWBTCPPacketData.rulerConfig_);
                    this.compassesConfig_ = mergeFromVisitor.visitMessage(this.compassesConfig_, wXWBTCPPacketData.compassesConfig_);
                    this.refConfig_ = mergeFromVisitor.visitMessage(this.refConfig_, wXWBTCPPacketData.refConfig_);
                    this.userInfo_ = mergeFromVisitor.visitMessage(this.userInfo_, wXWBTCPPacketData.userInfo_);
                    this.uid_ = mergeFromVisitor.visitString(!this.uid_.isEmpty(), this.uid_, !wXWBTCPPacketData.uid_.isEmpty(), wXWBTCPPacketData.uid_);
                    this.canvasInfo_ = mergeFromVisitor.visitMessage(this.canvasInfo_, wXWBTCPPacketData.canvasInfo_);
                    this.selectConfig_ = mergeFromVisitor.visitMessage(this.selectConfig_, wXWBTCPPacketData.selectConfig_);
                    this.myBusiness_ = mergeFromVisitor.visitMessage(this.myBusiness_, wXWBTCPPacketData.myBusiness_);
                    int i15 = this.businessType_;
                    boolean z14 = i15 != 0;
                    int i16 = wXWBTCPPacketData.businessType_;
                    if (i16 != 0) {
                        z = true;
                    }
                    this.businessType_ = mergeFromVisitor.visitInt(z14, i15, z, i16);
                    this.cursorPosition_ = mergeFromVisitor.visitMessage(this.cursorPosition_, wXWBTCPPacketData.cursorPosition_);
                    if (mergeFromVisitor == GeneratedMessageLite.MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= wXWBTCPPacketData.bitField0_;
                    }
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z = true;
                                    break;
                                case 8:
                                    this.type_ = codedInputStream.readEnum();
                                    break;
                                case 16:
                                    this.pointType_ = codedInputStream.readEnum();
                                    break;
                                case 26:
                                    this.courseId_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 34:
                                    this.pageId_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 40:
                                    this.lineIndex_ = codedInputStream.readUInt64();
                                    break;
                                case 58:
                                    if (!this.pointList_.isModifiable()) {
                                        this.pointList_ = GeneratedMessageLite.mutableCopy(this.pointList_);
                                    }
                                    this.pointList_.add(codedInputStream.readMessage(WXWBPoint.parser(), extensionRegistryLite));
                                    break;
                                case 64:
                                    this.width_ = codedInputStream.readInt32();
                                    break;
                                case 72:
                                    this.height_ = codedInputStream.readInt32();
                                    break;
                                case 88:
                                    this.msgId_ = codedInputStream.readUInt64();
                                    break;
                                case 101:
                                    this.lineWidth_ = codedInputStream.readFloat();
                                    break;
                                case 104:
                                    this.strokeColor_ = codedInputStream.readUInt32();
                                    break;
                                case 112:
                                    this.dataCreateTimestamp_ = codedInputStream.readUInt64();
                                    break;
                                case 125:
                                    this.rotation_ = codedInputStream.readFloat();
                                    break;
                                case Constants.ERR_WATERMARK_ARGB:
                                    this.fillColor_ = codedInputStream.readUInt32();
                                    break;
                                case 136:
                                    this.lineType_ = codedInputStream.readEnum();
                                    break;
                                case OmniModuleConstants.VIDEO_LOCAL_DUAL_ENCODER_PARAMS:
                                    WXWBPageConfig wXWBPageConfig = this.pageConfig_;
                                    WXWBPageConfig.Builder builder = wXWBPageConfig != null ? (WXWBPageConfig.Builder) wXWBPageConfig.toBuilder() : null;
                                    WXWBPageConfig readMessage = codedInputStream.readMessage(WXWBPageConfig.parser(), extensionRegistryLite);
                                    this.pageConfig_ = readMessage;
                                    if (builder == null) {
                                        break;
                                    } else {
                                        builder.mergeFrom(readMessage);
                                        this.pageConfig_ = builder.buildPartial();
                                        break;
                                    }
                                case 154:
                                    WXWBRevokeAndRecoverConfig wXWBRevokeAndRecoverConfig = this.revokeAndRecoverConfig_;
                                    WXWBRevokeAndRecoverConfig.Builder builder2 = wXWBRevokeAndRecoverConfig != null ? (WXWBRevokeAndRecoverConfig.Builder) wXWBRevokeAndRecoverConfig.toBuilder() : null;
                                    WXWBRevokeAndRecoverConfig readMessage2 = codedInputStream.readMessage(WXWBRevokeAndRecoverConfig.parser(), extensionRegistryLite);
                                    this.revokeAndRecoverConfig_ = readMessage2;
                                    if (builder2 == null) {
                                        break;
                                    } else {
                                        builder2.mergeFrom(readMessage2);
                                        this.revokeAndRecoverConfig_ = builder2.buildPartial();
                                        break;
                                    }
                                case 162:
                                    WXWBChooseConfig wXWBChooseConfig = this.chooseConfig_;
                                    WXWBChooseConfig.Builder builder3 = wXWBChooseConfig != null ? (WXWBChooseConfig.Builder) wXWBChooseConfig.toBuilder() : null;
                                    WXWBChooseConfig readMessage3 = codedInputStream.readMessage(WXWBChooseConfig.parser(), extensionRegistryLite);
                                    this.chooseConfig_ = readMessage3;
                                    if (builder3 == null) {
                                        break;
                                    } else {
                                        builder3.mergeFrom(readMessage3);
                                        this.chooseConfig_ = builder3.buildPartial();
                                        break;
                                    }
                                case 170:
                                    WXWBRulerConfig wXWBRulerConfig = this.rulerConfig_;
                                    WXWBRulerConfig.Builder builder4 = wXWBRulerConfig != null ? (WXWBRulerConfig.Builder) wXWBRulerConfig.toBuilder() : null;
                                    WXWBRulerConfig readMessage4 = codedInputStream.readMessage(WXWBRulerConfig.parser(), extensionRegistryLite);
                                    this.rulerConfig_ = readMessage4;
                                    if (builder4 == null) {
                                        break;
                                    } else {
                                        builder4.mergeFrom(readMessage4);
                                        this.rulerConfig_ = builder4.buildPartial();
                                        break;
                                    }
                                case 178:
                                    WXWBCompassesConfig wXWBCompassesConfig = this.compassesConfig_;
                                    WXWBCompassesConfig.Builder builder5 = wXWBCompassesConfig != null ? (WXWBCompassesConfig.Builder) wXWBCompassesConfig.toBuilder() : null;
                                    WXWBCompassesConfig readMessage5 = codedInputStream.readMessage(WXWBCompassesConfig.parser(), extensionRegistryLite);
                                    this.compassesConfig_ = readMessage5;
                                    if (builder5 == null) {
                                        break;
                                    } else {
                                        builder5.mergeFrom(readMessage5);
                                        this.compassesConfig_ = builder5.buildPartial();
                                        break;
                                    }
                                case 186:
                                    WXWBRefConfig wXWBRefConfig = this.refConfig_;
                                    WXWBRefConfig.Builder builder6 = wXWBRefConfig != null ? (WXWBRefConfig.Builder) wXWBRefConfig.toBuilder() : null;
                                    WXWBRefConfig readMessage6 = codedInputStream.readMessage(WXWBRefConfig.parser(), extensionRegistryLite);
                                    this.refConfig_ = readMessage6;
                                    if (builder6 == null) {
                                        break;
                                    } else {
                                        builder6.mergeFrom(readMessage6);
                                        this.refConfig_ = builder6.buildPartial();
                                        break;
                                    }
                                case 218:
                                    WXWBUserInfo wXWBUserInfo = this.userInfo_;
                                    WXWBUserInfo.Builder builder7 = wXWBUserInfo != null ? (WXWBUserInfo.Builder) wXWBUserInfo.toBuilder() : null;
                                    WXWBUserInfo readMessage7 = codedInputStream.readMessage(WXWBUserInfo.parser(), extensionRegistryLite);
                                    this.userInfo_ = readMessage7;
                                    if (builder7 == null) {
                                        break;
                                    } else {
                                        builder7.mergeFrom(readMessage7);
                                        this.userInfo_ = builder7.buildPartial();
                                        break;
                                    }
                                case 242:
                                    this.uid_ = codedInputStream.readStringRequireUtf8();
                                    break;
                                case 250:
                                    WXWBCanvasInfo wXWBCanvasInfo = this.canvasInfo_;
                                    WXWBCanvasInfo.Builder builder8 = wXWBCanvasInfo != null ? (WXWBCanvasInfo.Builder) wXWBCanvasInfo.toBuilder() : null;
                                    WXWBCanvasInfo readMessage8 = codedInputStream.readMessage(WXWBCanvasInfo.parser(), extensionRegistryLite);
                                    this.canvasInfo_ = readMessage8;
                                    if (builder8 == null) {
                                        break;
                                    } else {
                                        builder8.mergeFrom(readMessage8);
                                        this.canvasInfo_ = builder8.buildPartial();
                                        break;
                                    }
                                case 258:
                                    WXWBSelectAreaConfig wXWBSelectAreaConfig = this.selectConfig_;
                                    WXWBSelectAreaConfig.Builder builder9 = wXWBSelectAreaConfig != null ? (WXWBSelectAreaConfig.Builder) wXWBSelectAreaConfig.toBuilder() : null;
                                    WXWBSelectAreaConfig readMessage9 = codedInputStream.readMessage(WXWBSelectAreaConfig.parser(), extensionRegistryLite);
                                    this.selectConfig_ = readMessage9;
                                    if (builder9 == null) {
                                        break;
                                    } else {
                                        builder9.mergeFrom(readMessage9);
                                        this.selectConfig_ = builder9.buildPartial();
                                        break;
                                    }
                                case 266:
                                    WXWBPoint wXWBPoint = this.cursorPosition_;
                                    WXWBPoint.Builder builder10 = wXWBPoint != null ? (WXWBPoint.Builder) wXWBPoint.toBuilder() : null;
                                    WXWBPoint readMessage10 = codedInputStream.readMessage(WXWBPoint.parser(), extensionRegistryLite);
                                    this.cursorPosition_ = readMessage10;
                                    if (builder10 == null) {
                                        break;
                                    } else {
                                        builder10.mergeFrom(readMessage10);
                                        this.cursorPosition_ = builder10.buildPartial();
                                        break;
                                    }
                                case 8002:
                                    Any any = this.myBusiness_;
                                    Any.Builder builder11 = any != null ? (Any.Builder) any.toBuilder() : null;
                                    Any readMessage11 = codedInputStream.readMessage(Any.parser(), extensionRegistryLite);
                                    this.myBusiness_ = readMessage11;
                                    if (builder11 == null) {
                                        break;
                                    } else {
                                        builder11.mergeFrom(readMessage11);
                                        this.myBusiness_ = builder11.buildPartial();
                                        break;
                                    }
                                case 8008:
                                    this.businessType_ = codedInputStream.readUInt32();
                                    break;
                                default:
                                    if (codedInputStream.skipField(readTag)) {
                                        break;
                                    }
                                    z = true;
                                    break;
                            }
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (WXWBTCPPacketData.class) {
                            if (PARSER == null) {
                                PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }
                    return PARSER;
                default:
                    throw new UnsupportedOperationException();
            }
            return DEFAULT_INSTANCE;
        }

        static {
            WXWBTCPPacketData wXWBTCPPacketData = new WXWBTCPPacketData();
            DEFAULT_INSTANCE = wXWBTCPPacketData;
            wXWBTCPPacketData.makeImmutable();
        }

        public static WXWBTCPPacketData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WXWBTCPPacketData> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class Any extends GeneratedMessageLite<Any, Builder> implements AnyOrBuilder {
        /* access modifiers changed from: private */
        public static final Any DEFAULT_INSTANCE;
        private static volatile Parser<Any> PARSER = null;
        public static final int TYPE_URL_FIELD_NUMBER = 1;
        public static final int VALUE_FIELD_NUMBER = 2;
        private String typeUrl_ = "";
        private ByteString value_ = ByteString.EMPTY;

        private Any() {
        }

        public String getTypeUrl() {
            return this.typeUrl_;
        }

        public ByteString getTypeUrlBytes() {
            return ByteString.copyFromUtf8(this.typeUrl_);
        }

        /* access modifiers changed from: private */
        public void setTypeUrl(String str) {
            Objects.requireNonNull(str);
            this.typeUrl_ = str;
        }

        /* access modifiers changed from: private */
        public void clearTypeUrl() {
            this.typeUrl_ = getDefaultInstance().getTypeUrl();
        }

        /* access modifiers changed from: private */
        public void setTypeUrlBytes(ByteString byteString) {
            Objects.requireNonNull(byteString);
            checkByteStringIsUtf8(byteString);
            this.typeUrl_ = byteString.toStringUtf8();
        }

        public ByteString getValue() {
            return this.value_;
        }

        /* access modifiers changed from: private */
        public void setValue(ByteString byteString) {
            Objects.requireNonNull(byteString);
            this.value_ = byteString;
        }

        /* access modifiers changed from: private */
        public void clearValue() {
            this.value_ = getDefaultInstance().getValue();
        }

        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            if (!this.typeUrl_.isEmpty()) {
                codedOutputStream.writeString(1, getTypeUrl());
            }
            if (!this.value_.isEmpty()) {
                codedOutputStream.writeBytes(2, this.value_);
            }
        }

        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int i2 = 0;
            if (!this.typeUrl_.isEmpty()) {
                i2 = 0 + CodedOutputStream.computeStringSize(1, getTypeUrl());
            }
            if (!this.value_.isEmpty()) {
                i2 += CodedOutputStream.computeBytesSize(2, this.value_);
            }
            this.memoizedSerializedSize = i2;
            return i2;
        }

        public static Any parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static Any parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Any parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static Any parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Any parseFrom(InputStream inputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Any parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Any parseDelimitedFrom(InputStream inputStream) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static Any parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Any parseFrom(CodedInputStream codedInputStream) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Any parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Any any) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(any);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Any, Builder> implements AnyOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 r1) {
                this();
            }

            private Builder() {
                super(Any.DEFAULT_INSTANCE);
            }

            public String getTypeUrl() {
                return this.instance.getTypeUrl();
            }

            public ByteString getTypeUrlBytes() {
                return this.instance.getTypeUrlBytes();
            }

            public Builder setTypeUrl(String str) {
                copyOnWrite();
                this.instance.setTypeUrl(str);
                return this;
            }

            public Builder clearTypeUrl() {
                copyOnWrite();
                this.instance.clearTypeUrl();
                return this;
            }

            public Builder setTypeUrlBytes(ByteString byteString) {
                copyOnWrite();
                this.instance.setTypeUrlBytes(byteString);
                return this;
            }

            public ByteString getValue() {
                return this.instance.getValue();
            }

            public Builder setValue(ByteString byteString) {
                copyOnWrite();
                this.instance.setValue(byteString);
                return this;
            }

            public Builder clearValue() {
                copyOnWrite();
                this.instance.clearValue();
                return this;
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            boolean z = false;
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke[methodToInvoke.ordinal()]) {
                case 1:
                    return new Any();
                case 2:
                    return DEFAULT_INSTANCE;
                case 3:
                    return null;
                case 4:
                    return new Builder((AnonymousClass1) null);
                case 5:
                    GeneratedMessageLite.Visitor visitor = (GeneratedMessageLite.Visitor) obj;
                    Any any = (Any) obj2;
                    this.typeUrl_ = visitor.visitString(!this.typeUrl_.isEmpty(), this.typeUrl_, !any.typeUrl_.isEmpty(), any.typeUrl_);
                    boolean z2 = this.value_ != ByteString.EMPTY;
                    ByteString byteString = this.value_;
                    if (any.value_ != ByteString.EMPTY) {
                        z = true;
                    }
                    this.value_ = visitor.visitByteString(z2, byteString, z, any.value_);
                    GeneratedMessageLite.MergeFromVisitor mergeFromVisitor = GeneratedMessageLite.MergeFromVisitor.INSTANCE;
                    return this;
                case 6:
                    CodedInputStream codedInputStream = (CodedInputStream) obj;
                    ExtensionRegistryLite extensionRegistryLite = (ExtensionRegistryLite) obj2;
                    while (!z) {
                        try {
                            int readTag = codedInputStream.readTag();
                            if (readTag != 0) {
                                if (readTag == 10) {
                                    this.typeUrl_ = codedInputStream.readStringRequireUtf8();
                                } else if (readTag == 18) {
                                    this.value_ = codedInputStream.readBytes();
                                } else if (!codedInputStream.skipField(readTag)) {
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e) {
                            throw new RuntimeException(e.setUnfinishedMessage(this));
                        } catch (IOException e2) {
                            throw new RuntimeException(new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this));
                        }
                    }
                    break;
                case 7:
                    break;
                case 8:
                    if (PARSER == null) {
                        synchronized (Any.class) {
                            if (PARSER == null) {
                                PARSER = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }
                    return PARSER;
                default:
                    throw new UnsupportedOperationException();
            }
            return DEFAULT_INSTANCE;
        }

        static {
            Any any = new Any();
            DEFAULT_INSTANCE = any;
            any.makeImmutable();
        }

        public static Any getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Any> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
