/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow
 * @lint-ignore-every XPLATJSCOPYRIGHT1
 */

import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View} from 'react-native';
import AddForm from './components/AddForm'
import Main from './components/Main'

type Props = {};
export default class App extends Component<Props> {
  render() {
    return (
          <Main></Main>
    );
  }
}
