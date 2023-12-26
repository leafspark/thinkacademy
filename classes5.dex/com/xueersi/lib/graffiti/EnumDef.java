package com.xueersi.lib.graffiti;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public interface EnumDef {

    @Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
    public @interface LineType {
        public static final int Dashed = 1;
        public static final int Dotted = 2;
        public static final int Solid = 0;
    }

    @Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
    public @interface MessageType {
        public static final int AddMiniBoard = 15;
        public static final int BatchAction = 18;
        public static final int CANCEL = 1;
        public static final int CHOOSE = 9;
        public static final int CLEAR_ALL = 5;
        public static final int COMPASS = 12;
        public static final int CustomBusiness = 1000;
        public static final int CustomView = 17;
        public static final int DELETE_SHAPE = 4;
        public static final int DRAW = 3;
        public static final int DeleteMiniBoard = 16;
        public static final int GEOMETRY = 7;
        public static final int POINTER = 10;
        public static final int RECOVER = 0;
        public static final int RULER = 11;
        public static final int SCROLL = 6;
        public static final int SignalCourseWare = 20;
        public static final int TIMER = 13;
        public static final int TextBox = 19;
        public static final int UPDATE_SHAPE = 2;
        public static final int UpdateMiniBoard = 14;
    }

    @Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
    public @interface PointAction {
        public static final int END = 2;
        public static final int MOVE = 1;
        public static final int START = 0;
    }

    public @interface PointType {
        public static final int ARROW_2_LINE = 4;
        public static final int ARROW_LINE = 3;
        public static final int AUTO_SHAPE = 19;
        public static final int AXIS = 13;
        public static final int BatchCopy = 1003;
        public static final int BatchDelete = 1002;
        public static final int BatchMove = 1001;
        public static final int CIRCLE = 11;
        public static final int CONE = 16;
        public static final int COORDINATE = 18;
        public static final int CUBE = 14;
        public static final int CYLINDER = 15;
        public static final int ChemistryAlcoholLamp = 88;
        public static final int ChemistryBeaker = 76;
        public static final int ChemistryBentPipe = 83;
        public static final int ChemistryBenzeneRing = 87;
        public static final int ChemistryConicalFlask = 78;
        public static final int ChemistryCoordinate = 74;
        public static final int ChemistryElectrolyticTank1 = 84;
        public static final int ChemistryElectrolyticTank2 = 85;
        public static final int ChemistryElectrolyticTank3 = 86;
        public static final int ChemistryElectronic1 = 71;
        public static final int ChemistryElectronic2 = 72;
        public static final int ChemistryElectronic3 = 73;
        public static final int ChemistryFunnel = 79;
        public static final int ChemistryGasBottle1 = 89;
        public static final int ChemistryGasBottle2 = 90;
        public static final int ChemistryLongNeckFunnel = 81;
        public static final int ChemistrySeparatingFunnel = 82;
        public static final int ChemistryTestTube = 75;
        public static final int ChemistryUShapePipe = 80;
        public static final int ChemistryWildMouthBottle = 77;
        public static final int Circular = 96;
        public static final int CorpusTrapezoideum = 57;
        public static final int CubePlatform = 56;
        public static final int Curve1 = 32;
        public static final int Curve10 = 41;
        public static final int Curve11 = 42;
        public static final int Curve12 = 43;
        public static final int Curve13 = 44;
        public static final int Curve2 = 33;
        public static final int Curve3 = 34;
        public static final int Curve4 = 35;
        public static final int Curve5 = 36;
        public static final int Curve6 = 37;
        public static final int Curve7 = 38;
        public static final int Curve8 = 39;
        public static final int Curve9 = 40;
        public static final int CustomShapeImage = 100;
        public static final int CylinderPlatform = 54;
        public static final int DASHED = 17;
        public static final int DIAMOND = 20;
        public static final int ELLIPSES = 7;
        public static final int ELLIPSES2 = 24;
        public static final int ERASER = 1;
        public static final int FluorescentPen = 1000;
        public static final int FrontCube = 49;
        public static final int Hexagon = 48;
        public static final int ISOSCELES_TRIANGLE = 22;
        public static final int IsoscelesTrapezoid = 45;
        public static final int LINE = 2;
        public static final int LINE2 = 23;
        public static final int PARALLELOGRAM = 8;
        public static final int PEN = 0;
        public static final int POINTER = 21;
        public static final int POLYGONS = 9;
        public static final int Pentagon = 47;
        public static final int PhysicsAmmeter = 65;
        public static final int PhysicsBattery = 63;
        public static final int PhysicsBell = 70;
        public static final int PhysicsCoordinate = 60;
        public static final int PhysicsElectromotor = 69;
        public static final int PhysicsLight = 64;
        public static final int PhysicsResistance = 67;
        public static final int PhysicsRheostat = 68;
        public static final int PhysicsSwitch = 62;
        public static final int PhysicsVector = 61;
        public static final int PhysicsVoltmeter = 66;
        public static final int RECT = 6;
        public static final int RIGHT_TRIANGLE = 12;
        public static final int RectangularPyramid1 = 51;
        public static final int RectangularPyramid2 = 59;
        public static final int RightTrapezoid = 46;
        public static final int RriangularPyramid = 52;
        public static final int SELECT = 10;
        public static final int SideCube = 50;
        public static final int Sphere = 55;
        public static final int TRIANGLE = 5;
        public static final int ThreeCoordinateSystem = 31;
        public static final int TriangularPrism = 53;
        public static final int TruncatedTriangularPrism = 58;
        public static final int TwoCoordinateSystem = 30;
    }
}
