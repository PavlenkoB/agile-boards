var path = require('path');
var webpack = require('webpack');
var HtmlWebpackPlugin = require('html-webpack-plugin');

const PATHS = {
    source: path.join(__dirname, 'src'),
    build: path.join(__dirname, 'dist')
};

module.exports = {
    entry: [
        PATHS.source + '/index.jsx'
    ],
    output: {
        path: PATHS.build,
        filename: 'bundle.js'
    },
    resolve: {
        extensions: ['.js', '.jsx']
    },
    plugins: [
        new HtmlWebpackPlugin({
            template: path.join(__dirname, 'public/index.html')
        })
    ],
    module: {
        loaders: [
            {
                test: /\.jsx$/,
                include: PATHS.source,
                exclude: /node_modules/,
                loader: 'babel-loader',
                query: {
                    presets: ["es2015", "stage-0", "react"]
                }
            },
            {
                test: /\.js$/,
                include: PATHS.source,
                loader: 'babel-loader'
            },
            {
                test: /\.css$/,
                use: ['style-loader', 'css-loader']
            },
            {
                test: /\.(png|jpg|gif)$/,
                use: [
                    {
                        loader: 'file-loader',
                        options: {}
                    }
                ]
            },
            {
                test: /\.json$/,
                loader: 'raw-loader'
            },
            {
                test: /\.(woff(2)?|ttf|eot|svg)(\?v=\d+\.\d+\.\d+)?$/,
                use: [{
                    loader: 'file-loader',
                    options: {
                        name: '[name].[ext]',
                        outputPath: 'fonts/'
                    }
                }]
            }
        ]
    }
};
