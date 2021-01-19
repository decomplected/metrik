import React, { FC } from "react";
import { Form, Input, Button, Divider, Row, Col, Typography } from "antd";
import { css } from "@emotion/react";
import { ERROR_MESSAGES } from "../../constants/errorMessages";

const { Text } = Typography;

const groupTitleStyles = css({ fontWeight: "bold", display: "inline-block", marginBottom: 12 });

/* eslint-disable react/prop-types */
export const FieldsStep1: FC<{ onNext: () => void }> = ({ onNext }) => {
	return (
		<>
			<Text css={groupTitleStyles}>Dashboard Name</Text>

			<Row gutter={8} wrap={false}>
				<Col span={8}>
					<Form.Item
						label="Dashboard Name"
						name="dashboardName"
						rules={[{ required: true, message: ERROR_MESSAGES.EMPTY_DASHBOARD_NAME }]}>
						<Input />
					</Form.Item>
				</Col>
			</Row>

			<Divider />
			<Row>
				<Col span={24} style={{ textAlign: "right" }}>
					<Button
						type="primary"
						onClick={() => {
							onNext();
						}}>
						Next Step
					</Button>
				</Col>
			</Row>
		</>
	);
};
/* eslint-disable react/prop-types */
