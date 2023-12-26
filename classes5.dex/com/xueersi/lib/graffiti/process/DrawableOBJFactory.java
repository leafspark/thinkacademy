package com.xueersi.lib.graffiti.process;

import com.xueersi.lib.graffiti.draw.DrawableObject;
import com.xueersi.lib.graffiti.draw.point.PointDrawableObj;
import com.xueersi.lib.graffiti.draw.shape.basic.ArrowShape;
import com.xueersi.lib.graffiti.draw.shape.basic.Coordinate;
import com.xueersi.lib.graffiti.draw.shape.basic.CustomCircular;
import com.xueersi.lib.graffiti.draw.shape.basic.DiamondShape;
import com.xueersi.lib.graffiti.draw.shape.basic.DoubleArrowShape;
import com.xueersi.lib.graffiti.draw.shape.basic.EllipsesShape;
import com.xueersi.lib.graffiti.draw.shape.basic.EllipsesShape2;
import com.xueersi.lib.graffiti.draw.shape.basic.ImageShape;
import com.xueersi.lib.graffiti.draw.shape.basic.IsoscelesTriangle;
import com.xueersi.lib.graffiti.draw.shape.basic.LineShape;
import com.xueersi.lib.graffiti.draw.shape.basic.LineShape2;
import com.xueersi.lib.graffiti.draw.shape.basic.ParallelogramShape;
import com.xueersi.lib.graffiti.draw.shape.basic.RectShape;
import com.xueersi.lib.graffiti.draw.shape.basic.RightTriangle;
import com.xueersi.lib.graffiti.draw.shape.basic.TriangleShape;
import com.xueersi.lib.graffiti.draw.shape.chemistry.ChemistryAlcoholLamp;
import com.xueersi.lib.graffiti.draw.shape.chemistry.ChemistryBeaker;
import com.xueersi.lib.graffiti.draw.shape.chemistry.ChemistryBentPipe;
import com.xueersi.lib.graffiti.draw.shape.chemistry.ChemistryBenzeneRing;
import com.xueersi.lib.graffiti.draw.shape.chemistry.ChemistryConicalFlask;
import com.xueersi.lib.graffiti.draw.shape.chemistry.ChemistryCoordinate;
import com.xueersi.lib.graffiti.draw.shape.chemistry.ChemistryElectrolyticTank1;
import com.xueersi.lib.graffiti.draw.shape.chemistry.ChemistryElectrolyticTank2;
import com.xueersi.lib.graffiti.draw.shape.chemistry.ChemistryElectrolyticTank3;
import com.xueersi.lib.graffiti.draw.shape.chemistry.ChemistryElectronic1;
import com.xueersi.lib.graffiti.draw.shape.chemistry.ChemistryElectronic2;
import com.xueersi.lib.graffiti.draw.shape.chemistry.ChemistryElectronic3;
import com.xueersi.lib.graffiti.draw.shape.chemistry.ChemistryFunnel;
import com.xueersi.lib.graffiti.draw.shape.chemistry.ChemistryGasBottle1;
import com.xueersi.lib.graffiti.draw.shape.chemistry.ChemistryGasBottle2;
import com.xueersi.lib.graffiti.draw.shape.chemistry.ChemistryLongNeckFunnel;
import com.xueersi.lib.graffiti.draw.shape.chemistry.ChemistrySeparatingFunnel;
import com.xueersi.lib.graffiti.draw.shape.chemistry.ChemistryTestTube;
import com.xueersi.lib.graffiti.draw.shape.chemistry.ChemistryUShapePipe;
import com.xueersi.lib.graffiti.draw.shape.chemistry.ChemistryWildMouthBottle;
import com.xueersi.lib.graffiti.draw.shape.math.Cone;
import com.xueersi.lib.graffiti.draw.shape.math.CorpusTrapezoideum;
import com.xueersi.lib.graffiti.draw.shape.math.CubePlatform;
import com.xueersi.lib.graffiti.draw.shape.math.Curve001;
import com.xueersi.lib.graffiti.draw.shape.math.Curve002;
import com.xueersi.lib.graffiti.draw.shape.math.Curve003;
import com.xueersi.lib.graffiti.draw.shape.math.Curve004;
import com.xueersi.lib.graffiti.draw.shape.math.Curve005;
import com.xueersi.lib.graffiti.draw.shape.math.Curve006;
import com.xueersi.lib.graffiti.draw.shape.math.Curve007;
import com.xueersi.lib.graffiti.draw.shape.math.Curve008;
import com.xueersi.lib.graffiti.draw.shape.math.Curve009;
import com.xueersi.lib.graffiti.draw.shape.math.Curve010;
import com.xueersi.lib.graffiti.draw.shape.math.Curve011;
import com.xueersi.lib.graffiti.draw.shape.math.Curve012;
import com.xueersi.lib.graffiti.draw.shape.math.Curve013;
import com.xueersi.lib.graffiti.draw.shape.math.Cylinder;
import com.xueersi.lib.graffiti.draw.shape.math.CylinderPlatform;
import com.xueersi.lib.graffiti.draw.shape.math.FrontCube;
import com.xueersi.lib.graffiti.draw.shape.math.Hexagon;
import com.xueersi.lib.graffiti.draw.shape.math.IsoscelesTrapezoid;
import com.xueersi.lib.graffiti.draw.shape.math.Pentagon;
import com.xueersi.lib.graffiti.draw.shape.math.RectangularPyramid1;
import com.xueersi.lib.graffiti.draw.shape.math.RectangularPyramid2;
import com.xueersi.lib.graffiti.draw.shape.math.RightTrapezoid;
import com.xueersi.lib.graffiti.draw.shape.math.RriangularPyramid;
import com.xueersi.lib.graffiti.draw.shape.math.SideCube;
import com.xueersi.lib.graffiti.draw.shape.math.Sphere;
import com.xueersi.lib.graffiti.draw.shape.math.ThreeCoordinateSystem;
import com.xueersi.lib.graffiti.draw.shape.math.TriangularPrism;
import com.xueersi.lib.graffiti.draw.shape.math.TruncatedTriangularPrism;
import com.xueersi.lib.graffiti.draw.shape.math.TwoCoordinateSystem;
import com.xueersi.lib.graffiti.draw.shape.physics.PhysicsAmmeter;
import com.xueersi.lib.graffiti.draw.shape.physics.PhysicsBattery;
import com.xueersi.lib.graffiti.draw.shape.physics.PhysicsBell;
import com.xueersi.lib.graffiti.draw.shape.physics.PhysicsCoordinate;
import com.xueersi.lib.graffiti.draw.shape.physics.PhysicsElectromotor;
import com.xueersi.lib.graffiti.draw.shape.physics.PhysicsLight;
import com.xueersi.lib.graffiti.draw.shape.physics.PhysicsResistance;
import com.xueersi.lib.graffiti.draw.shape.physics.PhysicsRheostat;
import com.xueersi.lib.graffiti.draw.shape.physics.PhysicsSwitch;
import com.xueersi.lib.graffiti.draw.shape.physics.PhysicsVector;
import com.xueersi.lib.graffiti.draw.shape.physics.PhysicsVoltmeter;
import com.xueersi.lib.graffiti.draw.smooth.EraseDrawObjV2;
import com.xueersi.lib.graffiti.draw.smooth.FluorescentPen2;
import com.xueersi.lib.graffiti.draw.smooth.LaserPointerDrawableObj;
import com.xueersi.lib.graffiti.draw.smooth.SmoothCurveDrawObjV2;
import com.xueersi.lib.graffiti.utils.XesLog;
import java.util.HashMap;
import java.util.Map;

public class DrawableOBJFactory {
    private static final Map<Integer, DrawableObject.Factory> messageTypeFactoryMap;
    private static final Map<Integer, DrawableObject.Factory> pointTypeFactoryMap;
    private final DrawableObject.Config config = new DrawableObject.Config();

    static {
        HashMap hashMap = new HashMap();
        pointTypeFactoryMap = hashMap;
        HashMap hashMap2 = new HashMap();
        messageTypeFactoryMap = hashMap2;
        hashMap2.put(10, new PointDrawableObj.Factory());
        hashMap.put(1, new EraseDrawObjV2.Factory());
        hashMap.put(6, new RectShape.Factory());
        hashMap.put(5, new TriangleShape.Factory());
        hashMap.put(21, new LaserPointerDrawableObj.Factory());
        hashMap.put(3, new ArrowShape.Factory());
        hashMap.put(4, new DoubleArrowShape.Factory());
        hashMap.put(2, new LineShape.Factory());
        hashMap.put(7, new EllipsesShape.Factory());
        hashMap.put(0, new SmoothCurveDrawObjV2.Factory());
        hashMap.put(20, new DiamondShape.Factory());
        hashMap.put(8, new ParallelogramShape.Factory());
        hashMap.put(15, new Cylinder.Factory());
        hashMap.put(16, new Cone.Factory());
        hashMap.put(30, new TwoCoordinateSystem.Factory());
        hashMap.put(31, new ThreeCoordinateSystem.Factory());
        hashMap.put(32, new Curve001.Factory());
        hashMap.put(33, new Curve002.Factory());
        hashMap.put(34, new Curve003.Factory());
        hashMap.put(35, new Curve004.Factory());
        hashMap.put(36, new Curve005.Factory());
        hashMap.put(37, new Curve006.Factory());
        hashMap.put(38, new Curve007.Factory());
        hashMap.put(39, new Curve008.Factory());
        hashMap.put(40, new Curve009.Factory());
        hashMap.put(41, new Curve010.Factory());
        hashMap.put(42, new Curve011.Factory());
        hashMap.put(43, new Curve012.Factory());
        hashMap.put(44, new Curve013.Factory());
        hashMap.put(45, new IsoscelesTrapezoid.Factory());
        hashMap.put(46, new RightTrapezoid.Factory());
        hashMap.put(47, new Pentagon.Factory());
        hashMap.put(48, new Hexagon.Factory());
        hashMap.put(49, new FrontCube.Factory());
        hashMap.put(50, new SideCube.Factory());
        hashMap.put(57, new CorpusTrapezoideum.Factory());
        hashMap.put(51, new RectangularPyramid1.Factory());
        hashMap.put(59, new RectangularPyramid2.Factory());
        hashMap.put(52, new RriangularPyramid.Factory());
        hashMap.put(53, new TriangularPrism.Factory());
        hashMap.put(58, new TruncatedTriangularPrism.Factory());
        hashMap.put(54, new CylinderPlatform.Factory());
        hashMap.put(56, new CubePlatform.Factory());
        hashMap.put(55, new Sphere.Factory());
        hashMap.put(12, new RightTriangle.Factory());
        hashMap.put(18, new Coordinate.Factory());
        hashMap.put(22, new IsoscelesTriangle.Factory());
        hashMap.put(23, new LineShape2.Factory());
        hashMap.put(24, new EllipsesShape2.Factory());
        hashMap.put(60, new PhysicsCoordinate.Factory());
        hashMap.put(61, new PhysicsVector.Factory());
        hashMap.put(62, new PhysicsSwitch.Factory());
        hashMap.put(63, new PhysicsBattery.Factory());
        hashMap.put(64, new PhysicsLight.Factory());
        hashMap.put(65, new PhysicsAmmeter.Factory());
        hashMap.put(66, new PhysicsVoltmeter.Factory());
        hashMap.put(67, new PhysicsResistance.Factory());
        hashMap.put(68, new PhysicsRheostat.Factory());
        hashMap.put(69, new PhysicsElectromotor.Factory());
        hashMap.put(70, new PhysicsBell.Factory());
        hashMap.put(71, new ChemistryElectronic1.Factory());
        hashMap.put(72, new ChemistryElectronic2.Factory());
        hashMap.put(73, new ChemistryElectronic3.Factory());
        hashMap.put(74, new ChemistryCoordinate.Factory());
        hashMap.put(75, new ChemistryTestTube.Factory());
        hashMap.put(76, new ChemistryBeaker.Factory());
        hashMap.put(77, new ChemistryWildMouthBottle.Factory());
        hashMap.put(78, new ChemistryConicalFlask.Factory());
        hashMap.put(88, new ChemistryAlcoholLamp.Factory());
        hashMap.put(79, new ChemistryFunnel.Factory());
        hashMap.put(80, new ChemistryUShapePipe.Factory());
        hashMap.put(81, new ChemistryLongNeckFunnel.Factory());
        hashMap.put(82, new ChemistrySeparatingFunnel.Factory());
        hashMap.put(83, new ChemistryBentPipe.Factory());
        hashMap.put(84, new ChemistryElectrolyticTank1.Factory());
        hashMap.put(85, new ChemistryElectrolyticTank2.Factory());
        hashMap.put(86, new ChemistryElectrolyticTank3.Factory());
        hashMap.put(87, new ChemistryBenzeneRing.Factory());
        hashMap.put(89, new ChemistryGasBottle1.Factory());
        hashMap.put(90, new ChemistryGasBottle2.Factory());
        hashMap.put(96, CustomCircular.FACTORY);
        hashMap.put(1000, new FluorescentPen2.Factory());
        hashMap.put(100, new ImageShape.Factory());
    }

    public DrawableObject.Config getConfig() {
        return this.config;
    }

    public void addFactory(int i, DrawableObject.Factory factory) {
        pointTypeFactoryMap.put(Integer.valueOf(i), factory);
    }

    public DrawableObject onFactory(int i) {
        DrawableObject.Factory factory = pointTypeFactoryMap.get(Integer.valueOf(i));
        DrawableObject create = factory != null ? factory.create() : null;
        if (XesLog.isEnabled()) {
            XesLog.d("pointType=" + i);
        }
        if (create != null) {
            create.setConfig(this.config);
        }
        return create;
    }

    public DrawableObject onFactoryByMessageType(int i) {
        DrawableObject.Factory factory = messageTypeFactoryMap.get(Integer.valueOf(i));
        DrawableObject create = factory != null ? factory.create() : null;
        if (create != null) {
            create.setConfig(this.config);
        }
        if (XesLog.isEnabled()) {
            XesLog.d("messageType=" + i);
        }
        return create;
    }
}
