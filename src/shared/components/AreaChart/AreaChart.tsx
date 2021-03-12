import React from "react";
import { Area, AreaChart as ReChartAreaChart, Tooltip } from "recharts";
import { CurveType } from "recharts/types/shape/Curve";
import { AREA_GRADIENT_DEFAULT_COLOR } from "../../constants/styles";

interface AreaChartProps<T, K> {
	data: T[];
	dataKey: Exclude<K, symbol>;
	width?: number;
	height?: number;
	strokeColor?: string;
	strokeWidth?: number;
	areaGradientColor?: string;
	curveType?: CurveType;
}
const AreaChart = <T, K extends keyof T>({
	data,
	dataKey,
	width = 700,
	height = 350,
	strokeColor = "#000000",
	strokeWidth = 1,
	areaGradientColor = AREA_GRADIENT_DEFAULT_COLOR,
	curveType = "monotone",
}: AreaChartProps<T, K>) => {
	return (
		<>
			<ReChartAreaChart width={width} height={height} data={data}>
				<defs>
					<linearGradient id="areaColor" x1="0" y1="0%" x2="0" y2="100%">
						<stop offset="5%" stopColor={areaGradientColor} stopOpacity={1} />
						<stop offset="95%" stopColor={areaGradientColor} stopOpacity={0} />
					</linearGradient>
				</defs>
				<Tooltip />
				<Area
					type={curveType}
					dataKey={dataKey}
					stroke={strokeColor}
					strokeWidth={strokeWidth}
					fill="url(#areaColor)"
				/>
			</ReChartAreaChart>
		</>
	);
};
export default AreaChart;
