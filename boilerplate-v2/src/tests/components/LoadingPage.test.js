import React from 'react';
import { shallow } from enzyme;
import LoadingPage from '../../components/LoadingPage';

test('should correctly redner LoadingPage', () => {
    const wrapper = shallow(<LoadingPage/>);
    expect(wrapper).toMatchSnapshot();
});